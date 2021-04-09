package com.mobiledocker.mobiledocker.controller;

import com.google.gson.Gson;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.service.CityServiceDao;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import com.mobiledocker.mobiledocker.util.exception.BadRequestException;
import com.mobiledocker.mobiledocker.util.exception.DuplicateRecordException;
import com.mobiledocker.mobiledocker.util.exception.NotSupportedException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/model")
public class ModelController {
    private static final Logger log = LoggerFactory.getLogger(ModelController.class);


    @Autowired
    private StateDaoService stateDaoService;

    @Autowired
    private CityServiceDao cityDaoService;

    /*@RequestMapping(value = "", method = RequestMethod.GET)
    public List<CountryDto> index() {
        log.info("DemoController countries");
        modelMap.addAttribute("formData", new BookUser());
        modelMap.put("countries", countryServiceDao.findGenricAll());
        return "index";
        return countryServiceDao.findGenricAll();
    }*/
    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public StateDto addNewModal(@RequestBody StateCo stateCo, BindingResult bindingResult) {
        log.info("DemoController adding model" + stateCo .getModelName() +" "+stateCo.getBrandId());
        
        if (bindingResult.hasErrors())
            throw new BadRequestException("Bad Request. Params Missing");
        if(stateDaoService.isExist(stateCo.getModelName()))
        	throw new DuplicateRecordException("Model Name Already Exist : "+stateCo.getModelName());
        return stateDaoService.save(stateCo);
    }


    @RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public List<StateDto> loadStatesByCountry() {
        log.info("Load state by country" );
        Gson gson = new Gson();
        return (stateDaoService.findAll());
    }
    @RequestMapping(value = "/{brandId}", method = RequestMethod.GET)
    public List<StateDto> loadStatesByCountry(@PathVariable("brandId") String brandId) {
        log.info("Load state by brandId :"+brandId);
        Gson gson = new Gson();
        if(brandId =="" ||brandId==null||brandId=="undefined")
        	throw new NotSupportedException("Not supported");
        return (stateDaoService.findByBrandId(brandId));
    }

    @ResponseBody
    @RequestMapping(value = "/loadCitiesByState/{id}", method = RequestMethod.GET)
    public String loadCitiesByState(@PathVariable("id") int id) {
        log.info("Load Cities by State id" + id);
        Gson gson = new Gson();
        return gson.toJson(cityDaoService.findByState(id));
    }

}
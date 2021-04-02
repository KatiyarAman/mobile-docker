package com.mobiledocker.mobiledocker.controller;

import com.google.gson.Gson;
import com.mobiledocker.mobiledocker.entity.BookUser;
import com.mobiledocker.mobiledocker.service.CityServiceDao;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private CountryServiceDao countryServiceDao;

    @Autowired
    private StateDaoService stateDaoService;

    @Autowired
    private CityServiceDao cityDaoService;

    @GetMapping(value = "/")
    public String index(ModelMap modelMap) {
        log.info("DemoController countries");
        modelMap.addAttribute("formData", new BookUser());
        modelMap.put("countries", countryServiceDao.findGenricAll());
        return "index";
    }


    @ResponseBody
    @RequestMapping(value = "/loadStatesByCountry/{id}", method = RequestMethod.GET)
    public String loadStatesByCountry(@PathVariable("id") int id) {
        log.info("Load state by country" + id);
        Gson gson = new Gson();
        return gson.toJson(stateDaoService.findByCountryID(id));
    }

    @ResponseBody
    @RequestMapping(value = "/loadCitiesByState/{id}", method = RequestMethod.GET)
    public String loadCitiesByState(@PathVariable("id") int id) {
        log.info("Load Cities by State id" + id);
        Gson gson = new Gson();
        return gson.toJson(cityDaoService.findByState(id));
    }

}
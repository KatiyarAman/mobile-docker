package com.mobiledocker.mobiledocker.controller;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobiledocker.mobiledocker.ApplicationController;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.service.CityServiceDao;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import com.mobiledocker.mobiledocker.util.exception.BadRequestException;
@Controller
@RequestMapping
public class HomeController {
   private static final org.slf4j.Logger log=LoggerFactory.getLogger(HomeController.class);
   private Country country=new Country();
   @Autowired
	private CountryServiceDao countryServiceDao;
     @Autowired
     private CountryServiceDao countryService;
     @Autowired
 	 private CityServiceDao cityDaoService;
     @Autowired
     private StateDaoService stateService;
	 @RequestMapping("/t")
	 public String TermsCondition()
	 {  
		 return "Dashboard";
	 }
	
	 @RequestMapping(value="/form_component",method= {RequestMethod.GET,RequestMethod.POST})
	 public String getForms(ModelMap modelMap)
	 {   modelMap.put("countries", countryServiceDao.findAll());
		 return"forms";
		 
	 }
	 @RequestMapping(value="/addBrand",method= {RequestMethod.GET,RequestMethod.POST})
	 public com.mobiledocker.mobiledocker.entity.dto.CountryDto CountryDto(@RequestParam("brand") String selectbrand,@ModelAttribute CountryCo co,BindingResult bindingResult)
	 {
		 log.info("Home controller Add Brand  :"+selectbrand);
		 CountryCo obj=new CountryCo();
		 obj.setName(selectbrand);
		 return countryService.save(obj);
	 }

	@RequestMapping(value="/addNewModal",method = {RequestMethod.GET,RequestMethod.POST})
	public StateDto addNewModal(@RequestParam("brandId")int brandId,@RequestParam("idModel")String idModel,
			@ModelAttribute StateCo stateCo,BindingResult bindingResult) {
		log.info("DemoController countries"+brandId +" "+idModel);
		if (bindingResult.hasErrors())
            throw new BadRequestException("Bad Request. Params Missing");
		StateCo obj=new StateCo();
		obj.setName(idModel);
		obj.setBrandId(brandId);
		return stateService.save(obj);
	}

	 @RequestMapping(value="/basic_table",method= {RequestMethod.GET,RequestMethod.POST})
	 public String getTable()
	 {
		 return"basic_table";
	 }
}

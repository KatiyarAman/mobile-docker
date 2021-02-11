package com.mobiledocker.mobiledocker.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.service.BookUserDaoService;
import com.mobiledocker.mobiledocker.service.CityServiceDao;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
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
     private StateDaoService stateService;
     @Autowired
 	 private MobileWareHouseDaoService daoService;
	
     @Autowired
     private BookUserDaoService bookUserService;
     
     @RequestMapping(value="/t",method=RequestMethod.GET)
	 public String TermsCondition(ModelMap modelMap)
	{ /* 
	    Sorting by customerId i.e. genrated automatically in background
		 */
    	 modelMap.put("customer",bookUserService.findbySortedCustomerId());
		 return "Dashboard";
	 }
	
	 @RequestMapping(value="/form_component",method= {RequestMethod.GET,RequestMethod.POST})
	 public String getForms(ModelMap modelMap)
	 {   modelMap.put("countries", countryServiceDao.findAll());
		/*for the same page
		 * List<MobileWareHouseDto> mobileDetailsList=null;
		 * mobileDetailsList=daoService.findAllWareHouse();
		 * modelMap.put("users",mobileDetailsList); modelMap.put("mode","ALL_USERS");
		 */ 
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
	 public ModelAndView getTable(HttpServletRequest request, HttpServletResponse response)
	 {   ModelAndView mv=new ModelAndView("basic_table");
	 List<MobileWareHouseDto> mobileDetailsList=null;
	 mobileDetailsList=daoService.findAllWareHouse();
		 request.setAttribute("users",mobileDetailsList);
	      request.setAttribute("mode","ALL_USERS"); 
		 return mv;
	 }
	 
	/*
	 * // @RequestMapping(value="/UpdateMoblieParts",method=
	 * {RequestMethod.GET,RequestMethod.POST}) // public
	 * ResponseEntity<List<MobileWareHouseDto>>
	 * editUser(@PathVariable("warehouseId") String warehouseId){ // try { // return
	 * new ResponseEntity<List<MobileWareHouseDto>>
	 * (daoService.findByColumn(warehouseId),HttpStatus.OK); // } catch (Exception
	 * e) { // // TODO: handle exception // return new
	 * ResponseEntity<List<MobileWareHouseDto>>(HttpStatus.BAD_REQUEST); // } // }
	 */}

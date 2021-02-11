package com.mobiledocker.mobiledocker.controller;


import java.util.ArrayList;

import java.util.List;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.mobiledocker.mobiledocker.config.AppPropertiesConfig;

import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;




@Controller
@RequestMapping
public class GoForItController {
      
	private static final Logger log=LoggerFactory.getLogger(GoForItController.class);
	private List<MobileWarehouse> mobileDetails = new ArrayList<MobileWarehouse>();
	private MobileWarehouse mobileware=new MobileWarehouse();
	AppPropertiesConfig appProperties = new AppPropertiesConfig();
	Properties properties = appProperties.getPropValues();
	private Object loginBean= new MobileWarehouse();
	@Autowired
	private MobileWareHouseDaoService daoService;
	
	
	@RequestMapping(value="/myFunctionn",method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView GoForIt(Model model,@RequestParam("comboboxCountry")String brandId,@ModelAttribute("loginBean") MobileWarehouse loginbean
			,@RequestParam("comboboxState")String brandseries
			, HttpServletRequest request, HttpServletResponse response,
			HttpSession ses)  {
		List<MobileWareHouseDto> mobileDetailsList = null;
		ModelAndView mv=new ModelAndView("ListofMobile");
		loginBean =  loginbean;
		log.info("GoForItController :"+ brandId + " "+brandseries );	
		mobileDetailsList=daoService.findBybrandandModelSeries(brandId, brandseries);
		                  ses.setAttribute("mobileDetailsList","mobileDetailsList");
		                  request.setAttribute("mobileDetailsList","mobileDetailsList");		        	      
		        	      loginBean = ses.getAttribute("mobileDetailsList");		        	      
		        	      request.setAttribute("users",mobileDetailsList);
		        	      request.setAttribute("mode","ALL_USERS");      
		          return mv;            
		                
	         }
	
	@RequestMapping(value="/save-new",method= {RequestMethod.POST,RequestMethod.GET})
	 public String SaveNewData()
	 {
		return "";
	 }
}

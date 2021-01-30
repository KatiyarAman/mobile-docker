package com.mobiledocker.mobiledocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class ApplicationController {
	private static final Logger log=LoggerFactory.getLogger(ApplicationController.class);
	
	  @RequestMapping("/home")
	  @ResponseBody
	 public String hello() {
		  log.info("Application controller hello method():");
		 return "welocme to the application Controller";
	 }
	    @RequestMapping("/index")
	       public String setView()
	       {
	    	 return"index";
	       }
}

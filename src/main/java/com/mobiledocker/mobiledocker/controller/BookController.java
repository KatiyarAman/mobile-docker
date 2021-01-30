package com.mobiledocker.mobiledocker.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobiledocker.mobiledocker.entity.BookUser;
import com.mobiledocker.mobiledocker.service.BookUserDaoService;
@RestController
@Controller
public class BookController {

	private static final Logger log=LoggerFactory.getLogger(BookController.class);
	private BookUser bookuser=new BookUser();
	@Autowired
	private BookUserDaoService bookUserService;
	
	@RequestMapping(value = "/myFunction", method = {RequestMethod.POST,RequestMethod.GET})
	 public String registerUSer(@RequestParam("brand") String selectbrand,
			 @RequestParam("phone") String mobilenumber,@RequestParam("zipcode") String zipcode,
			 @RequestParam("fname") String fname,@RequestParam("issue") String descrip,	 
			 @RequestParam("model") String modelcode,@RequestParam("reason") String reason,
			 @RequestParam("cityname") String cityname,
			 HttpServletRequest request) {
		    log.info(mobilenumber+" "+selectbrand+" "+fname+" "+descrip+" "+modelcode+" "+reason+" "+zipcode+" "+cityname);
	        bookuser.setSelectbrands(selectbrand);
	        bookuser.setMobilenumber(mobilenumber);
	        bookuser.setZipcode(zipcode);
	        bookuser.setFname(fname);
	        bookuser.setDescrip(descrip);
	        bookuser.setSelectmodel(modelcode);
	        bookuser.setReason(reason);
	        bookuser.setCityname(cityname);
		   // System.out.println(bookobj.toString());
		    bookUserService.BookUser(bookuser);
		    return  "Get in touch soon.. !";
		
	}
}

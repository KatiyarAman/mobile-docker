package com.mobiledocker.mobiledocker.controller;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobiledocker.mobiledocker.entity.co.BookUserCo;
import com.mobiledocker.mobiledocker.entity.co.MobileWareHouseCo;
import com.mobiledocker.mobiledocker.entity.dto.BookUserDto;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.service.BookUserDaoService;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.util.exception.BadRequestException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="/data")
public class RestController {
	private static final Logger log=LoggerFactory.getLogger(RestController.class);
	 @Autowired
 	 private MobileWareHouseDaoService daoService;
	 @Autowired
	 private BookUserDaoService bookUserDaoService;
	 
	@RequestMapping(value="/sedit-user/{warehouseId}",method= {RequestMethod.GET,RequestMethod.POST},produces=MimeTypeUtils.APPLICATION_JSON_VALUE)
	 public ResponseEntity<MobileWareHouseDto> editUser(@PathVariable("warehouseId") String warehouseId,HttpServletRequest request)
	 {
		 log.info("Warehouse ID :"+warehouseId);
		 try {
			return new ResponseEntity<MobileWareHouseDto>(daoService.findByColum(warehouseId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<MobileWareHouseDto>(HttpStatus.BAD_REQUEST);
		}
	 }
	@RequestMapping(value="/UpdateMoblieParts",method= {RequestMethod.GET,RequestMethod.POST})
    public MobileWareHouseDto updateProduct(@RequestParam("seriesName") String seriesName,@RequestParam("brandName") String brandName,
	  @RequestParam("touchandlcd") String touchandlcd,@RequestParam("touchscreenglass") String touchscreenglass,@RequestParam("battery") String battery,@RequestParam("chargeport") String chargeport,
	  @RequestParam("loudspeaker") String loudspeaker,@RequestParam("earspeaker") String earspeaker,@RequestParam("audiojack") String audiojack,@RequestParam("microphone") String microphone,@RequestParam("warehouseId") String warehouseId,
	  @RequestParam("network") String network,@RequestParam("softwarediagnosis") String softwarediagnosis,@RequestParam("deadphonediagnosis") String deadphonediagnosis,@RequestParam("waterdiagnosis") String waterdiagnosis,
	  @RequestParam("standbyphone") String standbyphone,@RequestParam("brand") String brand,@RequestParam("brandSeries") int brandSeries,@ModelAttribute MobileWareHouseCo warehouseCo,BindingResult bindingResult)
   { 
  log.info("brand "+brand +" "+brandSeries +" "+warehouseId +" "+seriesName+" "+brandName);
   if (bindingResult.hasErrors())
     throw new BadRequestException("Bad Request. Params Missing");
     warehouseCo.setBrandseries(brandSeries);
    return daoService.updateProduct(warehouseCo,warehouseId);
 }
	/*
	 * status update ---for client
	*/
	@RequestMapping(value="/sedit-status/{customerId}",method= {RequestMethod.GET,RequestMethod.POST},produces=MimeTypeUtils.APPLICATION_JSON_VALUE)
     public ResponseEntity<BookUserDto> editStatus(@PathVariable("customerId") String customerId,HttpServletRequest request)
     {
		 log.info("status info getting by CustomerId :"+bookUserDaoService.findByColum(customerId).getCurrentstatus());	
		try {
		   
		return new ResponseEntity<BookUserDto>(bookUserDaoService.findByColum(customerId),HttpStatus.OK);
			  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<BookUserDto>(HttpStatus.BAD_REQUEST);
		}
     }

	/*
	 * auto referesh required ---->after updating the value
	*/
	@RequestMapping(value="/UpdateStatus",method= {RequestMethod.GET,RequestMethod.POST})
	public BookUserDto updateStatus(@RequestParam("customerId") String customerId,@ModelAttribute BookUserCo bookUserCo ,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			throw new BadRequestException("Bad Request. Params Missing");
		     log.info("getting details :"+bookUserCo.getCityname() +" "+bookUserCo.getCurrentstatus() +" "+bookUserCo.getMobilenumber());
		     return bookUserDaoService.updateStatus(bookUserCo,customerId);
		     
	}
}

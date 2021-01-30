package com.mobiledocker.mobiledocker.controller;


//
//import java.io.UnsupportedEncodingException;
//import java.util.Base64;
//import java.util.List;
//
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.MobileWareHouseCo;
import com.mobiledocker.mobiledocker.entity.dto.CountryDto;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import com.mobiledocker.mobiledocker.util.exception.BadRequestException;


@Controller
@RequestMapping
public class MobileWareHouseController {
     private static final Logger log=(Logger) LoggerFactory.getLogger(MobileWareHouseController.class);
     private MobileWarehouse mobilewareobj=new MobileWarehouse();
     private Country country=new Country();
     private StateDto state=new StateDto();
     @Autowired
     private MobileWareHouseDaoService warehouseService;
     @Autowired
     private CountryServiceDao brandService;
     
     @Autowired
      private StateDaoService seriesService;
 
// @RequestMapping(value="/addP",method= {RequestMethod.GET,RequestMethod.POST})
//      public String saveProduct(
//    		  @RequestParam("touchandlcdImage") MultipartFile touchandlcdImage,@RequestParam("touchscreenglassImage") MultipartFile touchscreenglassImage,
//    		  @RequestParam("batteryImage") MultipartFile batteryImage,@RequestParam("chargeportImage") MultipartFile chargeportImage,
//    		  @RequestParam("loudspeakerImage") MultipartFile loudspeakerImage,@RequestParam("earspeakerImage") MultipartFile earspeakerImage,
//    		  @RequestParam("audiojackImage") MultipartFile audiojackImage,@RequestParam("microphoneImage") MultipartFile microphoneImage,@RequestParam("networkImage") MultipartFile networkImage,
//    		  @RequestParam("softwarediagnosisImage") MultipartFile softwarediagnosisImage,@RequestParam("deadphonediagnosisImage") MultipartFile deadphonediagnosisImage,
//    		  @RequestParam("waterdiagnosisImage") MultipartFile waterdiagnosisImage,@RequestParam("standbyphoneImage") MultipartFile standbyphoneImage,
//    		  @RequestParam("touchandlcd") String touchandlcd,@RequestParam("touchscreenglass") String touchscreenglass,@RequestParam("battery") String battery,@RequestParam("chargeport") String chargeport,
//    		  @RequestParam("loudspeaker") String loudspeaker,@RequestParam("earspeaker") String earspeaker,@RequestParam("audiojack") String audiojack,@RequestParam("microphone") String microphone,
//    		  @RequestParam("network") String network,@RequestParam("softwarediagnosis") String softwarediagnosis,@RequestParam("deadphonediagnosis") String deadphonediagnosis,@RequestParam("waterdiagnosis") String waterdiagnosis,
//    		  @RequestParam("standbyphone") String standbyphone,@RequestParam("brand") int brand,@RequestParam("modelseries") int brandseries)
//         { // touchandlcd,touchscreenglass,battery,chargeport,loudspeaker,earspeaker,audiojack,microphone,network,softwarediagnosis,deadphonediagnosis,waterdiagnosis,standbyphone,brand,modelseries
//       //	productService.saveProductToDB(file, name, desc, price);
//	 log.info("brand "+brand);
//	        warehouseService.Save(touchandlcdImage,touchscreenglassImage,batteryImage,chargeportImage,loudspeakerImage,earspeakerImage,audiojackImage,microphoneImage,networkImage,
//			 softwarediagnosisImage,deadphonediagnosisImage,waterdiagnosisImage,standbyphoneImage,
//			 touchandlcd,touchscreenglass,battery,chargeport,loudspeaker,earspeaker,audiojack,microphone,network,softwarediagnosis,deadphonediagnosis,waterdiagnosis,standbyphone,brand,brandseries);
// 	    return "redirect:/listProducts.html";
//      }
 @RequestMapping(value="/addMoblieParts",method= {RequestMethod.GET,RequestMethod.POST})
 public String saveProduct(
		  @RequestParam("touchandlcd") String touchandlcd,@RequestParam("touchscreenglass") String touchscreenglass,@RequestParam("battery") String battery,@RequestParam("chargeport") String chargeport,
		  @RequestParam("loudspeaker") String loudspeaker,@RequestParam("earspeaker") String earspeaker,@RequestParam("audiojack") String audiojack,@RequestParam("microphone") String microphone,
		  @RequestParam("network") String network,@RequestParam("softwarediagnosis") String softwarediagnosis,@RequestParam("deadphonediagnosis") String deadphonediagnosis,@RequestParam("waterdiagnosis") String waterdiagnosis,
		  @RequestParam("standbyphone") String standbyphone,@RequestParam("brand") int brand,@RequestParam("brandSeries")int brandSeries,@ModelAttribute MobileWareHouseCo warehouseCo,BindingResult bindingResult)
    { 
        log.info("brand "+brand +" "+brandSeries);
        
       country= brandService.findById(brand);
       state=seriesService.findByColumn(brandSeries);
       System.out.println(state.getName());
       log.info("Size of contry "+country.getName() +  "  "+state.getName());
       warehouseCo.setSeriesName(state.getName());
       warehouseCo.setBrandName(country.getName());
       warehouseCo.setBrandseries(brandSeries);
       if (bindingResult.hasErrors())
           throw new BadRequestException("Bad Request. Params Missing");
       warehouseService.Save(warehouseCo);
		
    return "SAVED";
 }
}
// @RequestMapping(value = "/addProduct",method = RequestMethod.GET)
//	@ResponseBody
//	public ModelAndView returnAddProduct()
//	{
//	  ModelAndView mv = new ModelAndView();
//	  mv.setViewName("addProduct");
//	  //mv.addObject("var", "halim");
//	  return mv;
//	  
//	}
//	
//	@RequestMapping(value = "/listProduct",method= {RequestMethod.GET,RequestMethod.POST})
//	public ModelAndView returnListProduct(@RequestParam("brand") String brand,@RequestParam("modelseries") String brandseries,Model model) throws UnsupportedEncodingException
//	{
//	  ModelAndView mv = new ModelAndView();
//	  MobileWarehouse imagesObj=warehouseService.findBybrandandModelSeries(brand,brandseries);
//	  List<MobileWarehouse> productss = warehouseService.findAll();
//	  byte[] encode = java.util.Base64.getEncoder().encode(imagesObj.getAudiojackImage().getBytes());
//	  //String encode=Base64.getEncoder().encodeToString(products.);
//	 mv.setViewName("listProducts");
//	 mv.addObject("products", productss);
//	 mv.addObject("image", new String(encode, "UTF-8"));
//	 // model.addAttribute("id", imagesObj.getId());
//	 // model.addAttribute("brand", imagesObj.getBrand());
//	 // model.addAttribute("image", new String(encode, "UTF-8"));
//	  return mv;
//	  
//	}
//}

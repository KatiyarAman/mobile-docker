package com.mobiledocker.mobiledocker.controller;


//
//import java.io.UnsupportedEncodingException;
//import java.util.Base64;
//import java.util.List;
//

import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.co.MobileWareHouseCo;
import com.mobiledocker.mobiledocker.entity.dto.CountryDto;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import com.mobiledocker.mobiledocker.util.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping
public class MobileWareHouseController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(MobileWareHouseController.class);

    private MobileWarehouse mobilewareobj = new MobileWarehouse();

    private CountryDto brandDto = new CountryDto();

    private StateDto seriesDto = new StateDto();

    @Autowired
    private MobileWareHouseDaoService warehouseService;

    @Autowired
    private CountryServiceDao brandService;

    @Autowired
    private StateDaoService seriesService;


    @RequestMapping(value = "/addMoblieParts", method = {RequestMethod.GET, RequestMethod.POST})
    public MobileWareHouseDto saveProduct(
            @RequestParam("touchandlcd") String touchandlcd, @RequestParam("touchscreenglass") String touchscreenglass, @RequestParam("battery") String battery, @RequestParam("chargeport") String chargeport,
            @RequestParam("loudspeaker") String loudspeaker, @RequestParam("earspeaker") String earspeaker, @RequestParam("audiojack") String audiojack, @RequestParam("microphone") String microphone,
            @RequestParam("network") String network, @RequestParam("softwarediagnosis") String softwarediagnosis, @RequestParam("deadphonediagnosis") String deadphonediagnosis, @RequestParam("waterdiagnosis") String waterdiagnosis,
            @RequestParam("standbyphone") String standbyphone, @RequestParam("brand") String brand, @RequestParam("brandSeries") String brandSeries, @ModelAttribute MobileWareHouseCo warehouseCo, BindingResult bindingResult) {
        log.info("brand " + brand + " " + brandSeries);


        /* country= brandService.findById(b); */
        brandDto = brandService.findByColumn(brand);
        seriesDto = seriesService.findByColumn(brandSeries);
        System.out.println(seriesDto.getName());
        log.info("Size of contry " + brandDto.getName() + "  " + seriesDto.getName());
        warehouseCo.setSeriesName(seriesDto.getName());
        warehouseCo.setBrandName(brandDto.getName());
        warehouseCo.setBrandseries(brandSeries);
        if (bindingResult.hasErrors())
            throw new BadRequestException("Bad Request. Params Missing");
        return warehouseService.Save(warehouseCo);
    }
}


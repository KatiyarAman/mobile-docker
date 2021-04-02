package com.mobiledocker.mobiledocker.controller;


import com.mobiledocker.mobiledocker.entity.co.BookUserCo;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;
import com.mobiledocker.mobiledocker.entity.co.MobileWareHouseCo;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.dto.BookUserDto;
import com.mobiledocker.mobiledocker.entity.dto.CountryDto;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.service.BookUserDaoService;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import com.mobiledocker.mobiledocker.util.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/data")
public class RestController {
    private static final Logger log = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private MobileWareHouseDaoService daoService;

    @Autowired
    private BookUserDaoService bookUserDaoService;

    @Autowired
    private CountryServiceDao brandService;

    @Autowired
    private StateDaoService seriesService;

    @RequestMapping(value = "/sedit-user/{warehouseId}", method = {RequestMethod.GET, RequestMethod.POST}, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<MobileWareHouseDto> editUser(@PathVariable("warehouseId") String warehouseId, HttpServletRequest request) {
        log.info("Warehouse ID :" + warehouseId);
        try {
            return new ResponseEntity<MobileWareHouseDto>(daoService.findByColum(warehouseId), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<MobileWareHouseDto>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/UpdateMoblieParts", method = {RequestMethod.GET, RequestMethod.POST})
    public MobileWareHouseDto updateProduct(@RequestParam("seriesName") String seriesName, @RequestParam("brandName") String brandName,
                                            @RequestParam("touchandlcd") String touchandlcd, @RequestParam("touchscreenglass") String touchscreenglass, @RequestParam("battery") String battery, @RequestParam("chargeport") String chargeport,
                                            @RequestParam("loudspeaker") String loudspeaker, @RequestParam("earspeaker") String earspeaker, @RequestParam("audiojack") String audiojack, @RequestParam("microphone") String microphone, @RequestParam("warehouseId") String warehouseId,
                                            @RequestParam("network") String network, @RequestParam("softwarediagnosis") String softwarediagnosis, @RequestParam("deadphonediagnosis") String deadphonediagnosis, @RequestParam("waterdiagnosis") String waterdiagnosis,
                                            @RequestParam("standbyphone") String standbyphone, @RequestParam("brand") String brand, @RequestParam("brandSeries") String brandSeries, @ModelAttribute MobileWareHouseCo warehouseCo, BindingResult bindingResult) {
        log.info("brand " + brand + " " + brandSeries + " " + warehouseId + " " + seriesName + " " + brandName);
        if (bindingResult.hasErrors())
            throw new BadRequestException("Bad Request. Params Missing");
        warehouseCo.setBrandseries(brandSeries);
        return daoService.updateProduct(warehouseCo, warehouseId);
    }

    /* status update ---for client */
    @RequestMapping(value = "/sedit-status/{customerId}", method = {RequestMethod.GET, RequestMethod.POST}, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookUserDto> editStatus(@PathVariable("customerId") String customerId, HttpServletRequest request) throws IOException {
        log.info("status info getting by CustomerId :" + bookUserDaoService.findByColum(customerId).getCurrentstatus());
        try {

            return new ResponseEntity<BookUserDto>(bookUserDaoService.findByColum(customerId), HttpStatus.OK);

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<BookUserDto>(HttpStatus.BAD_REQUEST);
        }
    }

    /* auto referesh required ---->after updating the value */
    @RequestMapping(value = "/UpdateStatus", method = {RequestMethod.GET, RequestMethod.POST})
    public BookUserDto updateStatus(@RequestParam("customerId") String customerId, @ModelAttribute BookUserCo bookUserCo, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            throw new BadRequestException("Bad Request. Params Missing");
        log.info("getting details :" + bookUserCo.getCityname() + " " + bookUserCo.getCurrentstatus() + " " + bookUserCo.getMobilenumber());
        return bookUserDaoService.updateStatus(bookUserCo, customerId);

    }

    /* brand crud opertion start here --end line 129 */
    @RequestMapping(value = "/brandedit-user/{BrandId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDto> editBrands(@PathVariable("BrandId") String brandId, HttpServletRequest request) throws IOException {
        try {
            log.info("finding Brands By Brands Id For Updatation :" + brandId);

            return new ResponseEntity<CountryDto>(brandService.findByColumn(brandId), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<CountryDto>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/updateBrand", method = RequestMethod.POST)
    public CountryDto updateBrands(@RequestParam("brandId") String brandId, @RequestParam("brandname") String brandname,
                                   @ModelAttribute CountryCo countryCo, BindingResult bindingResult) {
        countryCo.setBrandname(brandname);
        countryCo.setBrandId(brandId);
        if (bindingResult.hasErrors())
            throw new BadRequestException("Bad Request. Params Missing");
        log.info("Update brands name :" + countryCo.getBrandname() + " " + countryCo.getBrandId());
        return brandService.updateBrand(countryCo, brandId);
    }

    @RequestMapping(value = "/branddelete-user/{BrandId}", method = RequestMethod.POST)
    public ResponseEntity<Void> branddeleteById(@PathVariable("BrandId") int brandId, HttpServletRequest request) throws IOException {
        try {
            log.info("Set Flag True : " + brandId);
            this.brandService.updateFlag(brandId);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /* brand crud opertion end here --end line 129 */

    /* series crud opertion start here -- */
    @RequestMapping(value = "/seriesedit-user/{seriesId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<StateDto> editSeries(@PathVariable("seriesId") String seriesId, HttpServletRequest request) {
        try {
            log.info("Finding series by seriesId for updation:" + seriesId);
            return new ResponseEntity<StateDto>(seriesService.findByColumn(seriesId), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<StateDto>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/updateSeries", method = RequestMethod.POST)
    public ResponseEntity<StateDto> updateSeries(@RequestParam("seriesname") String seriesname, @RequestParam("brandId") int brandId,
                                                 @RequestParam("seriesId") int seriesId, @ModelAttribute StateCo stateCo, BindingResult bindingResult) {
        log.info("Updating Start BradSeries by admin:" + seriesname + " " + brandId + " " + seriesId);
        if (bindingResult.hasErrors())
            throw new BadRequestException("Bad Request. Params Missing");
        stateCo.setName(seriesname);
        stateCo.setId(seriesId);
        try {
            StateDto stateDto = this.seriesService.UpdateSeries(stateCo);
            return ResponseEntity.ok().body(stateDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/seriesdeleteuser/{seriesId}", method = RequestMethod.POST)
    public ResponseEntity<Void> seriesDelete(@PathVariable("seriesId") int seriesId, HttpServletRequest request) {
        try {
            log.info("Series Delete By SeriesId :" + seriesId);
            this.seriesService.updateFlag(seriesId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // TODO: handle exception
        }
    }
    /* series crud opertion start here --end line  */
}   

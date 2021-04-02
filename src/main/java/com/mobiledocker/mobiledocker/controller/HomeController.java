package com.mobiledocker.mobiledocker.controller;

/*
  admin all form operation /t
*/

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.UserCo;
import com.mobiledocker.mobiledocker.entity.dto.BookUserDto;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.entity.dto.UserDto;
import com.mobiledocker.mobiledocker.service.BookUserDaoService;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import com.mobiledocker.mobiledocker.service.UserService;
import com.mobiledocker.mobiledocker.util.exception.BadRequestException;
import com.mobiledocker.mobiledocker.util.exception.DuplicateRecordException;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class HomeController {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HomeController.class);

    private Country country = new Country();

    @Autowired
    private CountryServiceDao countryServiceDao;

    @Autowired
    private StateDaoService stateService;

    @Autowired
    private MobileWareHouseDaoService daoService;

    @Autowired
    private BookUserDaoService bookUserService;
    
    @RequestMapping(value = "/t", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public List<BookUserDto> getBookUser(ModelMap modelMap) { /*
	    Sorting by customerId i.e. genrated automatically in background
		 */
        /*modelMap.put("customer", bookUserService.findbySortedCustomerId());
        return "Dashboard";*/
    	return bookUserService.findbySortedCustomerId();
    }

    @RequestMapping(value = "/form_component", method = {RequestMethod.GET, RequestMethod.POST}, consumes = "application/json", produces = "application/json")
    public List<com.mobiledocker.mobiledocker.entity.dto.CountryDto> getForms(ModelMap modelMap) {
        //modelMap.put("countries", countryServiceDao.findGenricAll());

        /*for the same page
         * List<MobileWareHouseDto> mobileDetailsList=null;
         * mobileDetailsList=daoService.findAllWareHouse();
         * modelMap.put("users",mobileDetailsList); modelMap.put("mode","ALL_USERS");
         */
        //modelMap.put("series", stateService.findAll());
        return countryServiceDao.findGenricAll();

    }

    @RequestMapping(value = "/addBrand", method = {RequestMethod.GET, RequestMethod.POST}, consumes = "application/json", produces = "application/json")
    public com.mobiledocker.mobiledocker.entity.dto.CountryDto CountryDto(@RequestParam("brand") String selectbrand, @ModelAttribute CountryCo co, BindingResult bindingResult) {
        log.info("Home controller Add Brand  :" + selectbrand);
        CountryCo obj = new CountryCo();
        obj.setBrandname(selectbrand);
        return countryServiceDao.Save(obj);
    }

    @RequestMapping(value = "/addNewModal", method = {RequestMethod.GET, RequestMethod.POST}, consumes = "application/json", produces = "application/json")
    public StateDto addNewModal(@RequestParam("brandId") int brandId, @RequestParam("idModel") String idModel,
                                @ModelAttribute StateCo stateCo, BindingResult bindingResult) {
        log.info("DemoController countries" + brandId + " " + idModel);
        if (bindingResult.hasErrors())
            throw new BadRequestException("Bad Request. Params Missing");
        StateCo obj = new StateCo();
        obj.setName(idModel);
        obj.setBrandId(brandId);
        return stateService.save(obj);
    }

    @RequestMapping(value = "/basic_table", method = {RequestMethod.GET, RequestMethod.POST}, consumes = "application/json", produces = "application/json")
    public List<MobileWareHouseDto> getTable(HttpServletRequest request, HttpServletResponse response) {
        /*ModelAndView mv = new ModelAndView("basic_table");
        List<MobileWareHouseDto> mobileDetailsList = null;
        mobileDetailsList = daoService.findAllWareHouse();
        request.setAttribute("users", mobileDetailsList);
        request.setAttribute("mode", "ALL_USERS")*/;
        return daoService.findAllWareHouse();
    }

    /*
     * for join result country or state//brand //series
     */
    @ResponseBody
    @RequestMapping(value = "/joins", method = {RequestMethod.GET, RequestMethod.POST}, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public List<State> joinsList(ModelMap modelMap) {
        modelMap.put("brandseries", stateService.findByJoins());
        return stateService.findByJoins();

    }
}

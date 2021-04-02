package com.mobiledocker.mobiledocker.controller;

import com.mobiledocker.mobiledocker.entity.dto.BookUserDto;
import com.mobiledocker.mobiledocker.entity.dto.CountryDto;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.service.BookUserDaoService;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * going to return json data thats why we use restController instead of controller
 */

@RestController
public class SearchController {

    private static final Logger log = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private BookUserDaoService bookUserService;

    @Autowired
    private CountryServiceDao brandService;

    @Autowired
    private StateDaoService seriesService;

    @Autowired
    private MobileWareHouseDaoService warehouseService;

    // search handler for dashboad bookeduser table
    @GetMapping("/search/{query}")
    public ResponseEntity<?> searchBookedUserTable(@PathVariable("query") String queryy) {
        System.out.println(queryy);
        List<BookUserDto> bookUserDto = this.bookUserService.SearchKeyword(queryy);
        return ResponseEntity.ok(bookUserDto);
    }

    //search brand class name-country
    @GetMapping(value = "/searchbrand/{query}")
    public ResponseEntity<?> searchBrand(@PathVariable("query") String query) {
        log.info("Search brand by input :" + query);
        List<CountryDto> countryDto = this.brandService.SearchKeyword(query);
        return ResponseEntity.ok(countryDto);
    }

    //search series class name-state
    @GetMapping(value = "/searchseries/{query}")
    public ResponseEntity<?> searchSeries(@PathVariable("query") String query) {
        log.info("Search series by input :" + query);
        List<StateDto> stateDto = this.seriesService.SearchKeyword(query);
        return ResponseEntity.ok(stateDto);
    }

    //search in warehouse table by brandname as well as seriesname
    @GetMapping(value = "/searchwarehouse/{query}")
    public ResponseEntity<?> SearchWarehouse(@PathVariable("query") String query) {
        log.info("Searching in Warehouse price table imput parameter:" + query);
        List<MobileWareHouseDto> warehouseDto = this.warehouseService.SearchKeyword(query);
        return ResponseEntity.ok(warehouseDto);


    }
}

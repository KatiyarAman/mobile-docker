package com.mobiledocker.mobiledocker.serviceImpl;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.Pagination;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;
import com.mobiledocker.mobiledocker.entity.dto.CountryDto;
import com.mobiledocker.mobiledocker.repository.CountryRepository;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.CustomerNotFoundException;
import com.mobiledocker.mobiledocker.util.exception.DiscoveryException;
import com.mobiledocker.mobiledocker.util.exception.EntityNotPersistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CountryServiceDaoImpl implements CountryServiceDao {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceDaoImpl.class);

    private List<Country> countryList = new ArrayList<Country>();

    private Country country = new Country();

    @Autowired
    private CountryRepository countryDao;

    @Autowired
    private ObjectBinder objectBinder;

    @Override
    public List<Country> findAll() {
        // TODO Auto-generated method stub
        log.info("DaoSerive find all: ");
        countryList = countryDao.findAll();
        if (countryList.isEmpty())
            throw new DiscoveryException("Requested resource can not be process due service connection problem. Please try again.");
        return countryList;
    }

    @Override
    public CountryDto Save(CountryCo cee) {

        // TODO Auto-generated method stub
        country = countryDao.Save(cee);
        if (country == null)
            throw new EntityNotPersistException("Entity is not able to save due to some system error. Please try again");
        return objectBinder.bindCountry(country);
        // throw new com.mobiledocker.mobiledocker.util.exception.EntityNotPersistException("Customer is not able to save due to some system error. Please try again");
    }

    @Override
    public CountryDto findByColum(int brand) {
        // TODO Auto-generated method stub
        country = countryDao.findByColum(brand);
        System.out.println(country.getBrandName());
        return objectBinder.bindCountry(country);
    }

    @Override
    public List<CountryDto> findGenricAll() {
        // TODO Auto-generated method stub
        return objectBinder.bindCountries(countryDao.findGenricAll());
    }

    @Override
    public CountryDto findByColumn(String brandId) {
        // TODO Auto-generated method stub
        country = countryDao.findByColumn("brandId",brandId);
        log.debug("Find by BrandId For Updating Brand :" + country);
        if (country == null)
            throw new DiscoveryException("Requested resource can not be process due service connection problem. Please try again.");
        return objectBinder.bindCountry(country);
    }

    @Override
    public CountryDto updateBrand(CountryCo countryCo, String brandId) {
        country = countryDao.findByColumn("brandId",brandId);
        if (country == null)
            throw new CustomerNotFoundException("Entity not found by this brandId " + brandId);
        country.setId(country.getId());
        country.setBrandName(countryCo.getBrandName());
        log.info("Update Insertion :" + country.getBrandName() + " " + country.getId());
        Country updatecountry = countryDao.save(country);
        return objectBinder.bindCountry(updatecountry);
    }

    @Override
    public void updateFlag(Long brandId) {
        // TODO Auto-generated method stub
        countryDao.updateFlag(brandId);
    }

    @Override
    public List<CountryDto> SearchKeyword(String query) {
    	Pagination pagination=new Pagination();
        countryList = countryDao.fetchSearch(pagination, query);
        if (countryList.isEmpty())
            throw new DiscoveryException("Requested resource can not be process due service connection problem. Please try again.");
        return objectBinder.bindCountries(countryList);
    }

	@Override
	public boolean isExist(String brandName) {
		return countryDao.findByColumn("brandName",brandName)!=null;
	}


}

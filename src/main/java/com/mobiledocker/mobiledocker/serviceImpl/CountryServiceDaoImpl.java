package com.mobiledocker.mobiledocker.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobiledocker.mobiledocker.Dao.CountryDao;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;
import com.mobiledocker.mobiledocker.entity.dto.CountryDto;
import com.mobiledocker.mobiledocker.repository.CountryRepository;
import com.mobiledocker.mobiledocker.service.CountryServiceDao;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.DiscoveryException;
import com.mobiledocker.mobiledocker.util.exception.EntityNotPersistException;
@Service
@Transactional
public class CountryServiceDaoImpl implements CountryServiceDao {
      
	private static final Logger log=LoggerFactory.getLogger(CountryServiceDaoImpl.class);
	private List<Country> countryList=new ArrayList<Country>();
	private Country country=new Country();
	 @Autowired
	 private CountryRepository countryDao;
	 @Autowired
     private ObjectBinder objectBinder;
	@Override
	public List<Country> findAll() {
		// TODO Auto-generated method stub
		log.info("DaoSerive find all: ");
		 countryList=countryDao.findAll();
				if(countryList.isEmpty())
					throw new DiscoveryException("Requested resource can not be process due service connection problem. Please try again.");		
		return countryList;
	}
	@Override
	public Country findById(int id) {
		// TODO Auto-generated method stub
		log.info("Country find by id Dao service "+id);
		return countryDao.findById(id);
	}
	@Override
	public CountryDto save(CountryCo cee) {
		
		// TODO Auto-generated method stub
		country=countryDao.save(cee);
		if (country == null)
            throw new EntityNotPersistException("Entity is not able to save due to some system error. Please try again");
		return objectBinder.bindCountry(country);
          // throw new com.mobiledocker.mobiledocker.util.exception.EntityNotPersistException("Customer is not able to save due to some system error. Please try again");
	}
	@Override
	public CountryDto findByColum(int brand) {
		// TODO Auto-generated method stub
		country= countryDao.findByColumn(brand);
		System.out.println(country.getName());
		return objectBinder.bindCountry(country);
	}
	
	

}

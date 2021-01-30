package com.mobiledocker.mobiledocker.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobiledocker.mobiledocker.Dao.CityDao;
import com.mobiledocker.mobiledocker.Dao.StateDao;
import com.mobiledocker.mobiledocker.entity.co.CityEntity;
import com.mobiledocker.mobiledocker.repository.CityRepository;
import com.mobiledocker.mobiledocker.service.CityServiceDao;
@Service("cityDaoService")
@Transactional
public class CityDaoServiceImpl implements CityServiceDao  {
	private static final Logger log=LoggerFactory.getLogger(CityDaoServiceImpl.class);
	@Autowired
	private CityRepository cityDao;
	
	@Override
	public List<CityEntity> findByState(int stateId) {
		// TODO Auto-generated method stub
		log.info("CityDaoService method FindBycountryId"+stateId);
		return cityDao.FindByCountry(stateId);
	}

}

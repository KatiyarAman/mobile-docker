package com.mobiledocker.mobiledocker.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobiledocker.mobiledocker.Dao.CountryDao;
import com.mobiledocker.mobiledocker.Dao.StateDao;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.repository.StateRepository;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.DataNotFoundException;
import com.mobiledocker.mobiledocker.util.exception.EntityNotPersistException;
@Service("stateDaoService")
@Transactional
public class StateDaoServiceImpl implements StateDaoService {
     
	private static final Logger log=LoggerFactory.getLogger(StateDaoServiceImpl.class);
	private List<State> listState =new ArrayList<State>();
	private State State=new State();
	@Autowired
	private StateRepository stateDao;
	@Autowired
	private ObjectBinder objectBinder;
	@Override
	public List<StateDto> findByCountry(int countryId) {
		// TODO Auto-generated method stub
		log.info("stateDaoService method FindBycountryId"+countryId);
		return objectBinder.bindStates(stateDao.FindByCountry(countryId));
	}
	@Override
	public StateDto save(StateCo stateCo) {
		// TODO Auto-generated method stub
		State=stateDao.save(stateCo);
				if (State == null)
		            throw new EntityNotPersistException("Entity is not able to save due to some system error. Please try again");
		return objectBinder.bindState(State);
	}
	@Override
	public List<StateEntity> findByCountryID(int countryId) {
		// TODO Auto-generated method stub
		return stateDao.FindByCountryID(countryId);
	}
	@Override
	public StateDto findByColumn(int countryId) {
		// TODO Auto-generated method stub
		log.info("findbyColumn "+countryId);
		State=stateDao.findByColumn(countryId);
		 if (State == null)
	            throw new DataNotFoundException("DATA not found with this ID ");
		return objectBinder.bindState(State);
	}

}

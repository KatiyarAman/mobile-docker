package com.mobiledocker.mobiledocker.serviceImpl;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.Pagination;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.repository.CountryRepository;
import com.mobiledocker.mobiledocker.repository.StateRepository;
import com.mobiledocker.mobiledocker.service.StateDaoService;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.*;
import com.mobiledocker.mobiledocker.util.exception.EntityNotPersistException;
import com.mobiledocker.mobiledocker.util.exception.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("stateDaoService")
@Transactional
public class StateDaoServiceImpl implements StateDaoService {

    private static final Logger log = LoggerFactory.getLogger(StateDaoServiceImpl.class);

    

    private State State = new State();

    @Autowired
    private StateRepository stateDao;
    
    @Autowired
    private CountryRepository countryDao;
    
    @Autowired
    private ObjectBinder objectBinder;

    @Override
    public List<StateDto> findByCountry(int countryId) {
        // TODO Auto-generated method stub
        log.info("stateDaoService method FindBycountryId" + countryId);
        return objectBinder.bindStates(stateDao.FindByCountry(countryId));
    }

    @Override
    public StateDto save(StateCo stateCo) {
        
    	Country country=countryDao.findByColumn("brandId",stateCo.getBrandId());
    	if(country==null)
    		throw new NotFoundException("Brand doesnot Exist by BrandId :"+stateCo.getBrandId());
    	State = stateDao.save(stateCo,country);
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
    public StateDto findByColumn(String countryId) {
        // TODO Auto-generated method stub
        log.info("findbyColumn " + countryId);
        State = stateDao.findByColumn(countryId);
        if (State == null)
            throw new DiscoveryException("Please try again Server is not able to communicate..");
        ;
        return objectBinder.bindState(State);
    }

    @Override
    public List<StateDto> findAll() {
        // TODO Auto-generated method stub
        log.info("find all  State : using Genric:");
        return objectBinder.bindStates(stateDao.findAll());
    }

    /* for join result country or state brand series */
    @Override
    public List<State> findByJoins() {

        return stateDao.findByJoins();
    }

    @Override
    public List<StateDto> SearchKeyword(String query) {
        // TODO Auto-generated method stub
    	Pagination pagination=new Pagination();
        return objectBinder.bindStates(stateDao.fetchSearch(pagination,query));
    }

    @Override
    public StateDto UpdateSeries(StateCo stateCo) {
        // TODO Auto-generated method stub
        log.info("Updation Data for Series :" + stateCo.getModelId() + " " + "" + " " + stateCo.getModelName());
        State.setModelId(stateCo.getModelId());;
        
        State updateState = stateDao.save(State);
        return objectBinder.bindState(updateState);
    }

    @Override
    public void updateFlag(Long seriesId) {
        // TODO Auto-generated method stub
        stateDao.updateFlage(seriesId);
    }

	@Override
	public boolean isExist(String modelName) {
		log.info("Duplication Checkinng while inserting Mmodel Name :"+modelName);
		return stateDao.findByColumn("modelName", modelName)!=null;
	}

	@Override
	public List<StateDto> findAllByBrandId(String brandId) {
		return objectBinder.bindStates(stateDao.findAllByColumn("country",brandId));
	}

	@Override
	public List<StateDto> findByBrandId(String brandId) {
           Country country=countryDao.findByColumn("brandId", brandId);
		return objectBinder.bindStates(stateDao.findAllByColumn("country",country));
	}


}

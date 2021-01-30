package com.mobiledocker.mobiledocker.Dao;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;

public interface StateDao {

	public List<State> FindByCountry (int countryId); 
	public List<StateEntity> FindByCountryID (int countryId); 
	public State save(StateCo stateCo);
	public State findByColumn(int countryId);
}

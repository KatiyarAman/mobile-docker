package com.mobiledocker.mobiledocker.Dao;

import java.util.List;
import java.util.Objects;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.Pagination;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;

public interface StateDao extends GenericRepository<State> {

	public List<State> FindByCountry (int countryId); 
	public List<StateEntity> FindByCountryID (int countryId); 
	public State save(StateCo stateCo, Country country);
	public State findByColumn(String countryId);
	public List<State> findAll();
	/* for join result country or state brand series */
	public List<State> findByJoins();
	public List<State> fetchSearch(Pagination pagination,String category);
	void updateFlage(Long seriesId);
}

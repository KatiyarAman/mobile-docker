package com.mobiledocker.mobiledocker.service;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;


public interface StateDaoService {
	public List<StateDto> findByCountry(int countryId);
    public List<StateEntity> findByCountryID(int countryId);
	public StateDto save(StateCo stateCo);
	public StateDto findByColumn(int countryId);
}

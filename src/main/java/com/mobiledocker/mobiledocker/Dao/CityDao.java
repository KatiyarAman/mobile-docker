package com.mobiledocker.mobiledocker.Dao;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.co.CityEntity;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;

public interface CityDao {
	public List<CityEntity> FindByCountry(int stateId);
}

package com.mobiledocker.mobiledocker.service;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.co.CityEntity;



public interface CityServiceDao {
	public List<CityEntity> findByState(int stateId);
}

package com.mobiledocker.mobiledocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobiledocker.mobiledocker.Dao.CityDao;
import com.mobiledocker.mobiledocker.entity.City;

public interface CityRepository extends JpaRepository<City, Integer>,CityDao {

}

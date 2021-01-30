package com.mobiledocker.mobiledocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobiledocker.mobiledocker.Dao.CountryDao;
import com.mobiledocker.mobiledocker.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>,CountryDao {

}

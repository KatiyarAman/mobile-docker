package com.mobiledocker.mobiledocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobiledocker.mobiledocker.Dao.CountryDao;
import com.mobiledocker.mobiledocker.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Long>,CountryDao{

	//public List<Country> findByNameContaining(String keywords);
}

package com.mobiledocker.mobiledocker.Dao;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;

public interface CountryDao {
 public List<Country> findAll();
 public Country findById(int id);
 public Country save(CountryCo countryCo);
 public Country findByColumn(int brand);
}

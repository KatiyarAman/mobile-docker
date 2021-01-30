package com.mobiledocker.mobiledocker.service;
import java.util.List;

import com.mobiledocker.mobiledocker.entity.*;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;

import com.mobiledocker.mobiledocker.entity.dto.CountryDto;

public interface CountryServiceDao {
 public List<Country> findAll();
 public Country findById(int id);
 public CountryDto save(CountryCo cee);
public CountryDto findByColum(int brand);
}

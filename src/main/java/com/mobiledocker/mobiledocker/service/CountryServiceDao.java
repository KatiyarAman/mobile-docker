package com.mobiledocker.mobiledocker.service;
import java.util.List;

import com.mobiledocker.mobiledocker.entity.*;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;

import com.mobiledocker.mobiledocker.entity.dto.CountryDto;

public interface CountryServiceDao {
 public List<Country> findAll();
 public List<CountryDto> findGenricAll();
 public CountryDto findByColumn(String brandId);

 public CountryDto Save(CountryCo cee);
 public CountryDto findByColum(int brand);
 public CountryDto updateBrand(CountryCo countryCo, String brandId);
 public void updateFlag(Long brandId);
 public List<CountryDto> SearchKeyword(String query);
public boolean isExist(String brandName);
 
}

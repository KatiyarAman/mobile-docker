package com.mobiledocker.mobiledocker.Dao;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.Pagination;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;

public interface CountryDao {
 public List<Country> findAll();
 public List<Country> findGenricAll();
 public Country findByColumn(String brandId);
 public Country findById(int id);
 public Country Save(CountryCo countryCo);
 public Country findByColum(int brand);
 public void updateFlag(int brandId);
 public List<Country> fetchSearch(Pagination pagination,String category);
}

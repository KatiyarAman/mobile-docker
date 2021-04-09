package com.mobiledocker.mobiledocker.Dao;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.Pagination;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;

public interface CountryDao extends GenericRepository<Country> {
 /*public List<Country> findAll();*/
 public List<Country> findGenricAll();
/* public Country findByColumn(String brandId);*/

 /* public Country findById(int id); while implementing brandid during angular integration
*/
 

 public Country Save(CountryCo countryCo);
 public Country findByColum(int brand);
 public void updateFlag(Long id);
 public List<Country> fetchSearch(Pagination pagination,String category);
}

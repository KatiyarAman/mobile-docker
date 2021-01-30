package com.mobiledocker.mobiledocker.Dao;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;

public interface MobileWareHouseDao {
	public List<MobileWarehouse> FindByBrandsAndModelNumber(String brand,String modelseries);
	//public List<Country> getAllCountryDetails(MobileWarehouse saBean);
	public List<MobileWarehouse> findBybrandandModelSeries(String brand, String brandseries);
}

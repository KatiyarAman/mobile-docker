package com.mobiledocker.mobiledocker.Dao;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;

public interface MobileWareHouseDao extends GenericRepository<MobileWarehouse> {
	public MobileWarehouse Save(MobileWarehouse mobilewareobj);
	
	public List<MobileWarehouse> FindByBrandsAndModelNumber(String brand,String modelseries);
	//public List<Country> getAllCountryDetails(MobileWarehouse saBean);
	public List<MobileWarehouse> findBybrandandModelSeries(String brand, String brandseries);

	/* for udating to get id if exist */
	/*public List<MobileWarehouse> findByColumn(String warehouseId);
	public MobileWarehouse get(String warehouseId);
	public MobileWarehouse findByColumnn(String warehouseId);*/
	
	
}

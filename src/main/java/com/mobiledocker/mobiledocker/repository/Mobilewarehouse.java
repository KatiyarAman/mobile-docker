package com.mobiledocker.mobiledocker.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mobiledocker.mobiledocker.Dao.MobileWareHouseDao;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;

public interface Mobilewarehouse extends  JpaRepository<MobileWarehouse, Integer>,MobileWareHouseDao {

	/*
	 * public List<MobileWarehouse> findByBrandNameAndSeriesNameContaining(String
	 * query);
	 */

/*	public List<MobileWarehouse> findByBrandNameContaining(String query);
*/
	

}

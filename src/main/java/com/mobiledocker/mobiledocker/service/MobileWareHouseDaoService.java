package com.mobiledocker.mobiledocker.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.co.MobileWareHouseCo;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;


public interface MobileWareHouseDaoService {

    public List<MobileWareHouseDto> FindByBrandsAndModelNumber(String brand, String modelseries);

    public List<MobileWarehouse> findAll();

    public List<MobileWareHouseDto> findBybrandandModelSeries(String brand, String brandseries);

    public MobileWareHouseDto Save(MobileWareHouseCo warehouseCo);

    public List<MobileWareHouseDto> findAllWareHouse();

    public List<MobileWareHouseDto> findAllByWarehouseId(String warehouseId);

    public MobileWareHouseDto findByWarehouseId(String warehouseId);

    public MobileWareHouseDto updateProduct(MobileWareHouseCo warehouseCo, String warehouseId);

    public List<MobileWareHouseDto> SearchKeyword(String query);
}

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

	public List<MobileWareHouseDto> FindByBrandsAndModelNumber(String brand,String modelseries);
	//public List<Country> getAllCountryDetails(MobileWarehouse saBean);

//	public void Save(MultipartFile touchandlcdImage, MultipartFile touchscreenglassImage, MultipartFile batteryImage,
//			MultipartFile chargeportImage, MultipartFile loudspeakerImage, MultipartFile earspeakerImage,
//			MultipartFile audiojackImage, MultipartFile microphoneImage, MultipartFile networkImage,
//			MultipartFile softwarediagnosisImage, MultipartFile deadphonediagnosisImage,
//			MultipartFile waterdiagnosisImage, MultipartFile standbyphoneImage, String touchandlcd,
//			String touchscreenglass, String battery, String chargeport, String loudspeaker, String earspeaker,
//			String audiojack, String microphone, String network, String softwarediagnosis, String deadphonediagnosis,
//			String waterdiagnosis, String standbyphone, int brand, int brandseries);
	

	        public List<MobileWarehouse> findAll();

			public List<MobileWareHouseDto> findBybrandandModelSeries(String brand, String brandseries);

			public MobileWareHouseDto Save( MobileWareHouseCo warehouseCo);

			public List<MobileWareHouseDto> findAllWareHouse();

			public List<MobileWareHouseDto> findByColumn(String warehouseId);
			public MobileWareHouseDto findByColum(String warehouseId);

			public MobileWareHouseDto updateProduct(MobileWareHouseCo warehouseCo ,String warehouseId);

			
	
}

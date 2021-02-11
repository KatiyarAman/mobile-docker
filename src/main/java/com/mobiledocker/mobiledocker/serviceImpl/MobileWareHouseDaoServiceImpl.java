package com.mobiledocker.mobiledocker.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mobiledocker.mobiledocker.Dao.MobileWareHouseDao;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.co.MobileWareHouseCo;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.repository.Mobilewarehouse;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.CustomerNotFoundException;
import com.mobiledocker.mobiledocker.util.exception.DiscoveryException;
@Service
@Transactional
public class MobileWareHouseDaoServiceImpl implements MobileWareHouseDaoService {
	private MobileWarehouse mobilewareobj=new MobileWarehouse();
	//public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";
	//public static String uploadDirectory ="/home/aman/eclipse-workspace/mobile-docker/src/main/resources/static/image";
	public final String uploadDirectory= new ClassPathResource("static/image/").getFile().getAbsolutePath();
	public MobileWareHouseDaoServiceImpl()throws IOException{}
	private static final Logger log=LoggerFactory.getLogger(MobileWareHouseDaoServiceImpl.class);
	private List<MobileWarehouse> warehouseDto=new ArrayList<MobileWarehouse>();
	 @Autowired
	private ObjectBinder objectBinder;
	 @Autowired
	 private Mobilewarehouse mobilewarehouseDao;
	@Override
	public List<MobileWareHouseDto> FindByBrandsAndModelNumber(String brand, String modelseries) {
		// TODO Auto-generated method stub
		log.info("MobilewareService "+brand+ " "+modelseries );
		warehouseDto=mobilewarehouseDao.FindByBrandsAndModelNumber(brand, modelseries);
		if(warehouseDto.isEmpty())
		throw new DiscoveryException("Requested resource can not be process due service connection problem. Please try again.");
		return objectBinder.bindWareHouses(warehouseDto);
	}
//	@Override
//	public void Save(MultipartFile touchandlcdImage, MultipartFile touchscreenglassImage, MultipartFile batteryImage,
//			MultipartFile chargeportImage, MultipartFile loudspeakerImage, MultipartFile earspeakerImage,
//			MultipartFile audiojackImage, MultipartFile microphoneImage, MultipartFile networkImage,
//			MultipartFile softwarediagnosisImage, MultipartFile deadphonediagnosisImage,
//			MultipartFile waterdiagnosisImage, MultipartFile standbyphoneImage, String touchandlcd,
//			String touchscreenglass, String battery, String chargeport, String loudspeaker, String earspeaker,
//			String audiojack, String microphone, String network, String softwarediagnosis, String deadphonediagnosis,
//			String waterdiagnosis, String standbyphone, int brand, int brandseries) {
//		// TODO Auto-generated method stub
//		String fileName = StringUtils.cleanPath(touchandlcdImage.getOriginalFilename());
//		String fileName1 = StringUtils.cleanPath(touchscreenglassImage.getOriginalFilename());
//		String fileName2 = StringUtils.cleanPath(batteryImage.getOriginalFilename());
//		String fileName3 = StringUtils.cleanPath(chargeportImage.getOriginalFilename());
//		String fileName4 = StringUtils.cleanPath(loudspeakerImage.getOriginalFilename());
//		String fileName5 = StringUtils.cleanPath(earspeakerImage.getOriginalFilename());
//		String fileName6 = StringUtils.cleanPath(audiojackImage.getOriginalFilename());
//		String fileName7 = StringUtils.cleanPath(microphoneImage.getOriginalFilename());
//		String fileName8 = StringUtils.cleanPath(networkImage.getOriginalFilename());
//		String fileName9 = StringUtils.cleanPath(softwarediagnosisImage.getOriginalFilename());
//		String fileName10 = StringUtils.cleanPath(deadphonediagnosisImage.getOriginalFilename());
//		String fileName11 = StringUtils.cleanPath(waterdiagnosisImage.getOriginalFilename());
//		String fileName12 = StringUtils.cleanPath(standbyphoneImage.getOriginalFilename());
//		Path fileNameAndPath =Paths.get(uploadDirectory,fileName);
//		Path fileNameAndPath1 =Paths.get(uploadDirectory,fileName1);
//		Path fileNameAndPath2 =Paths.get(uploadDirectory,fileName2);
//		Path fileNameAndPath3 =Paths.get(uploadDirectory,fileName3);
//		Path fileNameAndPath4 =Paths.get(uploadDirectory,fileName4);
//		Path fileNameAndPath5 =Paths.get(uploadDirectory,fileName5);
//		Path fileNameAndPath6 =Paths.get(uploadDirectory,fileName6);
//		Path fileNameAndPath7 =Paths.get(uploadDirectory,fileName7);
//		Path fileNameAndPath8 =Paths.get(uploadDirectory,fileName8);
//		Path fileNameAndPath9 =Paths.get(uploadDirectory,fileName9);
//		Path fileNameAndPath10 =Paths.get(uploadDirectory,fileName10);
//		Path fileNameAndPath11 =Paths.get(uploadDirectory,fileName11);
//		Path fileNameAndPath12 =Paths.get(uploadDirectory,fileName12);
//		
//		if(fileName.contains("..")||fileName1.contains("..")||fileName2.contains("..")||fileName3.contains("..")||
//				fileName4.contains("..")||fileName5.contains("..")||fileName6.contains("..")||fileName7.contains("..")||
//				fileName8.contains("..")||fileName9.contains("..")||fileName10.contains("..")||fileName11.contains("..")||
//				fileName12.contains(".."))
//		{
//			System.out.println("not a a valid file");
//		}
//		try {
//			Files.write(fileNameAndPath, touchandlcdImage.getBytes());
//			Files.write(fileNameAndPath1, touchscreenglassImage.getBytes());
//			Files.write(fileNameAndPath2, batteryImage.getBytes());
//			Files.write(fileNameAndPath3, chargeportImage.getBytes());
//			Files.write(fileNameAndPath4, loudspeakerImage.getBytes());
//			Files.write(fileNameAndPath5, earspeakerImage.getBytes());
//			Files.write(fileNameAndPath6, audiojackImage.getBytes());
//			Files.write(fileNameAndPath7, microphoneImage.getBytes());
//			Files.write(fileNameAndPath8, networkImage.getBytes());
//			Files.write(fileNameAndPath9, softwarediagnosisImage.getBytes());
//			Files.write(fileNameAndPath10, deadphonediagnosisImage.getBytes());
//			Files.write(fileNameAndPath11, waterdiagnosisImage.getBytes());
//			Files.write(fileNameAndPath12, standbyphoneImage.getBytes());
//			mobilewareobj.setTouchscreenglassImage(Base64.getEncoder().encodeToString(touchscreenglassImage.getBytes()));
//			mobilewareobj.setBatteryImage(Base64.getEncoder().encodeToString(batteryImage.getBytes()));
//			mobilewareobj.setChargeportImage(Base64.getEncoder().encodeToString(chargeportImage.getBytes()));
//			mobilewareobj.setLoudspeakerImage(Base64.getEncoder().encodeToString(loudspeakerImage.getBytes()));
//			mobilewareobj.setEarspeakerImage(Base64.getEncoder().encodeToString(earspeakerImage.getBytes()));
//			mobilewareobj.setAudiojackImage(Base64.getEncoder().encodeToString(audiojackImage.getBytes()));
//			mobilewareobj.setMicrophoneImage(Base64.getEncoder().encodeToString(microphoneImage.getBytes()));
//			mobilewareobj.setNetworkImage(Base64.getEncoder().encodeToString(networkImage.getBytes()));
//			mobilewareobj.setSoftwarediagnosisImage(Base64.getEncoder().encodeToString(softwarediagnosisImage.getBytes()));
//			mobilewareobj.setDeadphonediagnosisImage(Base64.getEncoder().encodeToString(deadphonediagnosisImage.getBytes()));
//			mobilewareobj.setWaterdiagnosisImage(Base64.getEncoder().encodeToString(waterdiagnosisImage.getBytes()));
//			mobilewareobj.setStandbyphoneImage(Base64.getEncoder().encodeToString(standbyphoneImage.getBytes()));
//			mobilewareobj.setTouchandlcdImage(Base64.getEncoder().encodeToString(touchandlcdImage.getBytes()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//	}
	@Override
	public List<MobileWarehouse> findAll() {
		// TODO Auto-generated method stub
		return mobilewarehouseDao.findAll();
	}
	@Override
	public List<MobileWareHouseDto> findBybrandandModelSeries(String brand, String brandseries) {
		// TODO Auto-generated method stub
		return objectBinder.bindWareHouses(mobilewarehouseDao.findBybrandandModelSeries(brand,brandseries));
		
	}
	
	@Override
	public MobileWareHouseDto Save( MobileWareHouseCo warehouseCo) {
		System.out.println("get the name "+warehouseCo.getBrandseries());
		// TODO Auto-generated method stub
		mobilewareobj.setAudiojack(warehouseCo.getAudiojack());
		mobilewareobj.setBattery(warehouseCo.getBattery());
		mobilewareobj.setBrand(warehouseCo.getBrand());
		mobilewareobj.setBrandseries(warehouseCo.getBrandseries());
		mobilewareobj.setChargeport(warehouseCo.getChargeport());
		mobilewareobj.setDeadphonediagnosis(warehouseCo.getDeadphonediagnosis());
		mobilewareobj.setEarspeaker(warehouseCo.getEarspeaker());
		mobilewareobj.setLoudspeaker(warehouseCo.getLoudspeaker());
		mobilewareobj.setMicrophone(warehouseCo.getMicrophone());
		mobilewareobj.setNetwork(warehouseCo.getNetwork());
		mobilewareobj.setSoftwarediagnosis(warehouseCo.getSoftwarediagnosis());
		mobilewareobj.setStandbyphone(warehouseCo.getStandbyphone());
		mobilewareobj.setTouchandlcd(warehouseCo.getTouchandlcd());
		mobilewareobj.setTouchscreenglass(warehouseCo.getTouchscreenglass());
		mobilewareobj.setWaterdiagnosis(warehouseCo.getWaterdiagnosis());
		mobilewareobj.setBrandName(warehouseCo.getBrandName());
		mobilewareobj.setSeriesName(warehouseCo.getSeriesName());
		MobileWarehouse warehousate=mobilewarehouseDao.save(mobilewareobj);
		return objectBinder.bindWareHouse(warehousate);
	}

	@Override
	public List<MobileWareHouseDto> findAllWareHouse() {
		// TODO Auto-generated method stub
		return objectBinder.bindWareHouses(mobilewarehouseDao.findAll());
	}

	@Override
	public List<MobileWareHouseDto> findByColumn(String warehouseId) {
		// TODO Auto-generated method stub
		return objectBinder.bindWareHouses(mobilewarehouseDao.findByColumn(warehouseId));
	}

	@Override
	public MobileWareHouseDto updateProduct(MobileWareHouseCo warehouseCo,String warehouseId) {
		// TODO Auto-generated method stub
		MobileWarehouse warehouse=mobilewarehouseDao.get(warehouseId);
		if(warehouse ==null)
			throw new CustomerNotFoundException("Entity not found by this warehouseId " + warehouseId);
		mobilewareobj.setId(warehouse.getId());
		mobilewareobj.setAudiojack(warehouseCo.getAudiojack());
		mobilewareobj.setBattery(warehouseCo.getBattery());
		mobilewareobj.setBrand(warehouseCo.getBrand());
		mobilewareobj.setBrandseries(warehouseCo.getBrandseries());
		mobilewareobj.setChargeport(warehouseCo.getChargeport());
		mobilewareobj.setDeadphonediagnosis(warehouseCo.getDeadphonediagnosis());
		mobilewareobj.setEarspeaker(warehouseCo.getEarspeaker());
		mobilewareobj.setLoudspeaker(warehouseCo.getLoudspeaker());
		mobilewareobj.setMicrophone(warehouseCo.getMicrophone());
		mobilewareobj.setNetwork(warehouseCo.getNetwork());
		mobilewareobj.setSoftwarediagnosis(warehouseCo.getSoftwarediagnosis());
		mobilewareobj.setStandbyphone(warehouseCo.getStandbyphone());
		mobilewareobj.setTouchandlcd(warehouseCo.getTouchandlcd());
		mobilewareobj.setTouchscreenglass(warehouseCo.getTouchscreenglass());
		mobilewareobj.setWaterdiagnosis(warehouseCo.getWaterdiagnosis());
		mobilewareobj.setBrandName(warehouseCo.getBrandName());
		mobilewareobj.setSeriesName(warehouseCo.getSeriesName());
		MobileWarehouse warehouseupdate=mobilewarehouseDao.save(mobilewareobj);
		return objectBinder.bindWareHouse(warehouseupdate);
	}

	@Override
	public MobileWareHouseDto findByColum(String warehouseId) {
		// TODO Auto-generated method stub
		return objectBinder.bindWareHouse(mobilewarehouseDao.findByColumnn(warehouseId));
	}
	
	
	
    
	
	

}

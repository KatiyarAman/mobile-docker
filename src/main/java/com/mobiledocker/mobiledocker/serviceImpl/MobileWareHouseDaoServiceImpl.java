package com.mobiledocker.mobiledocker.serviceImpl;

import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.co.MobileWareHouseCo;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.repository.Mobilewarehouse;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.CustomerNotFoundException;
import com.mobiledocker.mobiledocker.util.exception.DiscoveryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MobileWareHouseDaoServiceImpl implements MobileWareHouseDaoService {
    private MobileWarehouse mobilewareobj = new MobileWarehouse();

    //public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";
    //public static String uploadDirectory ="/home/aman/eclipse-workspace/mobile-docker/src/main/resources/static/image";
    public final String uploadDirectory = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public MobileWareHouseDaoServiceImpl() throws IOException {
    }

    private static final Logger log = LoggerFactory.getLogger(MobileWareHouseDaoServiceImpl.class);

    private List<MobileWarehouse> warehouseDto = new ArrayList<MobileWarehouse>();

    @Autowired
    private ObjectBinder objectBinder;

    @Autowired
    private Mobilewarehouse mobilewarehouseDao;

    @Override
    public List<MobileWareHouseDto> FindByBrandsAndModelNumber(String brand, String modelseries) {
        // TODO Auto-generated method stub
        log.info("MobilewareService " + brand + " " + modelseries);
        warehouseDto = mobilewarehouseDao.FindByBrandsAndModelNumber(brand, modelseries);
        if (warehouseDto.isEmpty())
            throw new DiscoveryException("Requested resource can not be process due service connection problem. Please try again.");
        return objectBinder.bindWareHouses(warehouseDto);
    }

    @Override
    public List<MobileWarehouse> findAll() {
        // TODO Auto-generated method stub
        return mobilewarehouseDao.findAll();
    }

    @Override
    public List<MobileWareHouseDto> findBybrandandModelSeries(String brand, String brandseries) {
        // TODO Auto-generated method stub
        return objectBinder.bindWareHouses(mobilewarehouseDao.findBybrandandModelSeries(brand, brandseries));

    }

    @Override
    public MobileWareHouseDto Save(MobileWareHouseCo warehouseCo) {
        System.out.println("get the name " + warehouseCo.getBrandseries());
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
        log.info("while persisting Data :" + mobilewareobj.getWarehouseId());
        MobileWarehouse warehousate = mobilewarehouseDao.Save(mobilewareobj);
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
    public MobileWareHouseDto updateProduct(MobileWareHouseCo warehouseCo, String warehouseId) {
        // TODO Auto-generated method stub
        MobileWarehouse warehouse = mobilewarehouseDao.get(warehouseId);
        if (warehouse == null)
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
        log.info("Update by Id :" + warehouse.getId());
        MobileWarehouse warehouseupdate = mobilewarehouseDao.save(mobilewareobj);
        return objectBinder.bindWareHouse(warehouseupdate);
    }

    @Override
    public MobileWareHouseDto findByColum(String warehouseId) {
        // TODO Auto-generated method stub
        return objectBinder.bindWareHouse(mobilewarehouseDao.findByColumnn(warehouseId));
    }

    @Override
    public List<MobileWareHouseDto> SearchKeyword(String query) {
        // TODO Auto-generated method stub
        return objectBinder.bindWareHouses(mobilewarehouseDao.findByBrandNameContaining(query));
    }


}

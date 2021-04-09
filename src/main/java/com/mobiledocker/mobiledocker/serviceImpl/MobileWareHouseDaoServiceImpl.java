package com.mobiledocker.mobiledocker.serviceImpl;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.MobileWareHouseCo;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.repository.CountryRepository;
import com.mobiledocker.mobiledocker.repository.Mobilewarehouse;
import com.mobiledocker.mobiledocker.repository.StateRepository;
import com.mobiledocker.mobiledocker.service.MobileWareHouseDaoService;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.CustomerNotFoundException;
import com.mobiledocker.mobiledocker.util.exception.DiscoveryException;
import com.mobiledocker.mobiledocker.util.exception.NotFoundException;
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
    
    @Autowired
    private CountryRepository countryDao;
    
    @Autowired
    private StateRepository stateDao;

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
        Country country=countryDao.findByColumn("brandId",warehouseCo.getBrandId());
        if(country==null)
        	throw new NotFoundException("Brand does not exist by brandId "+warehouseCo.getBrandId());
        State state=stateDao.findByColumn("modelId",warehouseCo.getModelId());
        if(state==null)
    	     throw new NotFoundException("Model does not exist by modelId "+warehouseCo.getModelId());

    	     MobileWarehouse mobilewarehouse=new MobileWarehouse(warehouseCo.getTouchandlcd(),warehouseCo.getTouchscreenglass(),warehouseCo.getBattery(),
    	    		 warehouseCo.getChargeport(),warehouseCo.getLoudspeaker(),warehouseCo.getEarspeaker(),warehouseCo.getAudiojack(),
    	    		 warehouseCo.getMicrophone(),warehouseCo.getNetwork(),warehouseCo.getSoftwarediagnosis(),warehouseCo.getDeadphonediagnosis(),
    	    		 warehouseCo.getWaterdiagnosis(),warehouseCo.getStandbyphone(),country,state);
       
        MobileWarehouse warehousate = mobilewarehouseDao.Save(mobilewarehouse);
        return objectBinder.bindWareHouse(warehousate);
    }

    @Override
    public List<MobileWareHouseDto> findAllWareHouse() {
        // TODO Auto-generated method stub
        return objectBinder.bindWareHouses(mobilewarehouseDao.findAll());
    }

    @Override
    public List<MobileWareHouseDto> findAllByWarehouseId(String warehouseId) {
        // TODO Auto-generated method stub
        return objectBinder.bindWareHouses(mobilewarehouseDao.findAllByColumn("warehouseId",warehouseId));
    }

    @Override
    public MobileWareHouseDto updateProduct(MobileWareHouseCo warehouseCo, String warehouseId) {
        // TODO Auto-generated method stub
        MobileWarehouse warehouse = mobilewarehouseDao.findByColumn("warehouseId", warehouseId);
        if (warehouse == null)
            throw new CustomerNotFoundException("Entity not found by this warehouseId " + warehouseId);
        mobilewareobj.setId(warehouse.getId());
        mobilewareobj.setAudiojack(warehouseCo.getAudiojack());
        mobilewareobj.setBattery(warehouseCo.getBattery());
      
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
      
        log.info("Update by Id :" + warehouse.getId());
        MobileWarehouse warehouseupdate = mobilewarehouseDao.save(mobilewareobj);
        return objectBinder.bindWareHouse(warehouseupdate);
    }

    @Override
    public MobileWareHouseDto findByWarehouseId(String warehouseId) {
        return objectBinder.bindWareHouse(mobilewarehouseDao.findByColumn("warehouseId", warehouseId));
    }

    @Override
    public List<MobileWareHouseDto> SearchKeyword(String query) {
        // TODO Auto-generated method stub
        return objectBinder.bindWareHouses(mobilewarehouseDao.findAll());
    }


}

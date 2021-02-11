package com.mobiledocker.mobiledocker.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;
import javax.sql.DataSource;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.mobiledocker.mobiledocker.Dao.MobileWareHouseDao;
import com.mobiledocker.mobiledocker.entity.co.CityEntity;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;


@Repository
public class MobileWareHouseDaoImpl extends GenricRepositroyImpl<MobileWarehouse> implements MobileWareHouseDao,InitializingBean {
	private static final Logger log=LoggerFactory.getLogger(MobileWareHouseDaoImpl.class);
	
  
	@Override
	public List<MobileWarehouse> FindByBrandsAndModelNumber(String brand, String modelseries) {
		// TODO Auto-generated method stub
    	int brandd=Integer.parseInt(brand);
    	int modelseriess=Integer.parseInt(modelseries);
    	List<MobileWarehouse> mobilewarehouse=null;
    	
//    //	List<EmployeeDTO> resultList = null;
		try (Session session = getCurrentSession()) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<MobileWarehouse> criteriaQuery = builder.createQuery(MobileWarehouse.class);
		Root<MobileWarehouse> root = criteriaQuery.from(MobileWarehouse.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal((root.get("brandseries")),(root.get("brand"))));
		mobilewarehouse = session.createQuery(criteriaQuery).list();
		//Query<MobileWarehouse> query = session.createQuery(criteriaQuery);
		List<MobileWarehouse> mobilewarehouse1 = mobilewarehouse;
		mobilewarehouse1.forEach(System.out::println);
	} catch (HibernateException e) {
		e.printStackTrace();
	}

return mobilewarehouse;
    }


	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		super.setEntity(MobileWarehouse.class);
	}


	@Override
	public List<MobileWarehouse> findBybrandandModelSeries(String brand, String brandseries) {
		// TODO Auto-generated method stub
		return super.findByColuAndId("brand", brand, "brandseries", brandseries);
	}


	@Override
	public List<MobileWarehouse> findByColumn(String warehouseId) {
		// TODO Auto-generated method stub
		return super.findAllByColumn("warehouseId",warehouseId);
	}


	@Override
	public MobileWarehouse get(String warehouseId) {
		// TODO Auto-generated method stub
		return super.findByColumn("warehouseId",warehouseId);
	}


	@Override
	public MobileWarehouse findByColumnn(String warehouseId) {
		// TODO Auto-generated method stub
		return super.findByColumnIsDeleted("warehouseId", warehouseId);
	}
	
}

package com.mobiledocker.mobiledocker.DaoImpl;

import com.mobiledocker.mobiledocker.Dao.MobileWareHouseDao;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class MobileWareHouseDaoImpl extends GenricRepositroyImpl<MobileWarehouse> implements MobileWareHouseDao, InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(MobileWareHouseDaoImpl.class);


    @Override
    public List<MobileWarehouse> FindByBrandsAndModelNumber(String brand, String modelseries) {
        // TODO Auto-generated method stub
        int brandd = Integer.parseInt(brand);
        int modelseriess = Integer.parseInt(modelseries);
        List<MobileWarehouse> mobilewarehouse = null;

//    //	List<EmployeeDTO> resultList = null;
        try (Session session = getCurrentSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<MobileWarehouse> criteriaQuery = builder.createQuery(MobileWarehouse.class);
            Root<MobileWarehouse> root = criteriaQuery.from(MobileWarehouse.class);
            criteriaQuery.select(root);
            criteriaQuery.where(builder.equal((root.get("brandseries")), (root.get("brand"))));
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
        return super.findAllByColumn("warehouseId", warehouseId);
    }


    @Override
    public MobileWarehouse get(String warehouseId) {
        // TODO Auto-generated method stub
        return super.findByColumn("warehouseId", warehouseId);
    }


    @Override
    public MobileWarehouse findByColumnn(String warehouseId) {
        // TODO Auto-generated method stub
        return super.findByColumnIsDeleted("warehouseId", warehouseId);
    }


    @Override
    public MobileWarehouse Save(MobileWarehouse mobilewareobj) {
        // TODO Auto-generated method stub
        log.info("Inserting new Data into Mobilewarehouse :");
        return super.save(mobilewareobj);
    }

}

package com.mobiledocker.mobiledocker.DaoImpl;

import com.mobiledocker.mobiledocker.Dao.CityDao;
import com.mobiledocker.mobiledocker.entity.City;
import com.mobiledocker.mobiledocker.entity.co.CityEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cityDao")
public class CityDaoImpl extends GenricRepositroyImpl<City> implements CityDao, InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(CityDaoImpl.class);

    @Override
    public List<CityEntity> FindByCountry(int stateId) {
        // TODO Auto-generated method stub
        List<CityEntity> cityEntity = null;
        Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            cityEntity = session.createQuery("select c.id as id, "
                    + " c.name as name "
                    + "from City c "
                    + "where state.id=:stateId")
                    .setInteger("stateId", stateId)
                    .setResultTransformer(Transformers.aliasToBean(CityEntity.class))
                    .list();
            transaction.commit();

        } catch (Exception e) {
            // TODO: handle exception
            cityEntity = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return cityEntity;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        super.setEntity(City.class);
    }

}

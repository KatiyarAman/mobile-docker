package com.mobiledocker.mobiledocker.DaoImpl;

import com.mobiledocker.mobiledocker.Dao.CountryDao;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.Pagination;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

@Repository
public class CountryDaoImpl extends GenricRepositroyImpl<Country> implements CountryDao, InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(CountryDaoImpl.class);

    private Country country = new Country();

    @Override
    public List<Country> findAll() {
        List<Country> countries = null;
        log.info("Country Dao impl +");
        Session session = getCurrentSession();
        //	Session session=sessionFactory.openSession();HibernateConfig
        //log.info("Session"+session.toString());
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            countries = session.createQuery("from Country").list();
            log.info("Inside try block Query" + countries);
            transaction.commit();
        } catch (Exception e) {
            countries = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return countries;
    }

    @Override
    public Country findById(int id) {
        // TODO Auto-generated method stub
        Country country = null;
        Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String query = "FROM Country C WHERE C.id = :id";
            country = (Country) session.createQuery(query)
                    .setInteger("id", id).uniqueResult();
            transaction.commit();

        } catch (Exception e) {
            // TODO: handle exception
            country = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return country;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        super.setEntity(Country.class);
    }

    @Override
    public Country Save(CountryCo countryCo) {
        // TODO Auto-generated method stub
        System.out.println(countryCo.getBrandname());
        country.setName(countryCo.getBrandname());
        return super.save(country);
    }

    @Override
    public Country findByColum(int brand) {
        // TODO Auto-generated method stub
        return super.findByColumnIsDeleted("id", brand);
    }

    @Override
    public List<Country> findGenricAll() {
        // TODO Auto-generated method stub
        log.info("Find all By Generic CountryDao :");
        return super.list();
    }

    @Override
    public Country findByColumn(String brandId) {
        // TODO Auto-generated method stub


        return super.findByColumn("id", brandId);

    }
    @Override
	public List<Country> fetchSearch(Pagination pagination, String category) {
		List<Country> countryList=new ArrayList<>();
		try(Session session=getCurrentSession()) {
			CriteriaBuilder cb=session.getCriteriaBuilder();
			
			if(!pagination.isIgnorable()) {
				pagination.verify(session.createQuery(countAllCategory(cb,category)).getSingleResult().intValue());
			}
			if (pagination.isIgnorable())
                countryList.addAll(session.createQuery(getAllCategoryByCategoryName(cb, category)).getResultList());
            else
                countryList.addAll(session.createQuery(getAllCategoryByCategoryName(cb, category))
                        .setFirstResult(pagination.getOffset()).setMaxResults(pagination.getLimit()).getResultList());
				
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return countryList;
	}

    private CriteriaQuery<Country> getAllCategoryByCategoryName(CriteriaBuilder cb, String category) {
    	CriteriaQuery<Country> cq=cb.createQuery(Country.class);
		Root<Country> root=cq.from(Country.class);
		cq.select(root);
		cq.where(cb.and(cb.like(root.get("name"),category+"%"),cb.isFalse(root.get("deleted"))));
return cq;
	}

	private CriteriaQuery<Long> countAllCategory(CriteriaBuilder cb,String category) {
				CriteriaQuery<Long> cq=cb.createQuery(Long.class);
				Root<Country> root=cq.from(Country.class);
				cq.select(cb.count(root));
				cq.where(cb.and(cb.like(root.get("name"),category+"%"),cb.isFalse(root.get("deleted"))));
    	return cq;
	}

	@Override
    public void updateFlag(int brandId) {

        super.setDeleted(brandId);
    }
}

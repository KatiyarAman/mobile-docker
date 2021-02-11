package com.mobiledocker.mobiledocker.DaoImpl;

import java.util.List;



import org.hibernate.Session;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.stereotype.Repository;


import com.mobiledocker.mobiledocker.Dao.CountryDao;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.co.CountryCo;
@Repository
public class CountryDaoImpl extends GenricRepositroyImpl<Country> implements CountryDao,InitializingBean{
   private static final Logger log=LoggerFactory.getLogger(CountryDaoImpl.class);  
	private Country country=new Country();
	@Override
	public List<Country> findAll() {
		List<Country> countries=null;
		log.info("Country Dao impl +");
		Session session = getCurrentSession();
	//	Session session=sessionFactory.openSession();HibernateConfig
		//log.info("Session"+session.toString());
		Transaction transaction=null;
		    try {
		    	transaction=session.beginTransaction();
		    	countries=session.createQuery("from Country").list();
		    	log.info("Inside try block Query"+countries);
		    	transaction.commit();
		    }catch(Exception e){
		    	countries=null;
		    	if(transaction != null) {
		    		 transaction.rollback();
		    	}
		    }finally {
		    	session.close();
		    }

		return countries;
	}
	@Override
	public Country findById(int id) {
		// TODO Auto-generated method stub
		Country country=null;
		Session session = getCurrentSession();
		 Transaction transaction=null;
		 try {
			transaction=session.beginTransaction();
			String query="FROM Country C WHERE C.id = :id";
			country=(Country) session.createQuery(query)
					.setInteger("id",id).uniqueResult();
			transaction.commit();
			 
		} catch (Exception e) {
			// TODO: handle exception
			country=null;
			 if(transaction !=null)
			 {transaction.rollback();}
		}finally {
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
	public Country save(CountryCo countryCo) {
		// TODO Auto-generated method stub
		System.out.println(countryCo.getName());
		country.setName(countryCo.getName());
		return super.save(country);
	}
	@Override
	public Country findByColumn(int brand) {
		// TODO Auto-generated method stub
		return super.findByColumnIsDeleted("id",brand);
	}}



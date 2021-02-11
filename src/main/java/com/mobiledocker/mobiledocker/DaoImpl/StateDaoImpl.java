package com.mobiledocker.mobiledocker.DaoImpl;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.hibernate.query.Query;

import org.springframework.stereotype.Repository;

import com.mobiledocker.mobiledocker.Dao.StateDao;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;
@Repository
public class StateDaoImpl extends GenricRepositroyImpl<State> implements StateDao ,InitializingBean{
	private static final Logger log=LoggerFactory.getLogger(StateDaoImpl.class);
	
	private State state=new State();
 
	@Override
	public List<State> FindByCountry(int countryId) {
		// TODO Auto-generated method stub
		log.info("Load States by CountryId"+countryId);
		List<State> states=null;
		try (Session session = getCurrentSession()) {
			 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
			Root<State> rootEmp = criteriaQuery.from(State.class);
			criteriaQuery.multiselect(rootEmp);
			criteriaQuery.where(builder.equal(rootEmp.get("country"),countryId));
			Query query = session.createQuery(criteriaQuery).setResultTransformer(Transformers.aliasToBean(State.class));
			states = query.getResultList();		
				log.info("stateDaoImpl :"+states);
		           } 
		
		return states;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		super.setEntity(State.class);
	}
	@Override
	public State save(StateCo stateCo) {
		// TODO Auto-generated method stub
		state.setName(stateCo.getName());
		state.setBrandId(stateCo.getBrandId());
		return super.save(state);
	}
	@Override
	@SuppressWarnings("deprecation")
	public List<StateEntity> FindByCountryID(int countryId) {
		// TODO Auto-generated method stub
		List<StateEntity> stateEntity=null;
		Session session = getCurrentSession();
		Transaction transaction=null;
		try {transaction=session.beginTransaction();
		String query="select s.id as id, "
				+" s.name as name "
				+"from State s "
				+"where brandId=:countryId";
//			stateEntity=session.createQuery("select s.id as id, "
//		+" s.name as name "
//		+"from State s "
//		+"where brandId=:countryId")
		//Query q = getCurrentSession()).Query(query);
	// because of hibernate orm is 6 version we need 5 version
		stateEntity=session.createQuery(query)
					
					.setInteger("countryId",countryId)
					.setResultTransformer(Transformers.aliasToBean(StateEntity.class))
					.list();
					
					transaction.commit();
			
		} catch (Exception e) {
			stateEntity=null;
			if(transaction!=null)
			{
				transaction.rollback();
			}
			// TODO: handle exception
		}finally {
	    	session.close();
	    }
		System.out.println(stateEntity.size());
		return stateEntity;
	}
	@Override
	public State findByColumn(int countryId) {
		// TODO Auto-generated method stub		
		return super.findByColumnIsDeleted("id",countryId);
	   }

	}



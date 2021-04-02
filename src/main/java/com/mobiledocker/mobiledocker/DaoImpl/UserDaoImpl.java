package com.mobiledocker.mobiledocker.DaoImpl;



import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import com.mobiledocker.mobiledocker.Dao.UserDao;
import com.mobiledocker.mobiledocker.entity.User;
@Repository
public class UserDaoImpl extends GenricRepositroyImpl<User> implements UserDao,InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		super.setEntity(User.class);
		
	}

	@Override
	public User findByColumns(String userName, String userPassword) {
		System.out.println("************* :" +userPassword);
		User user=null;
		try (Session session=getCurrentSession()){
			CriteriaBuilder cb=session.getCriteriaBuilder();
			CriteriaQuery<User> cq=cb.createQuery(User.class);
			Root<User> root=cq.from(User.class);
			cq.select(root).where(cb.and(cb.equal(root.get("userEmail"), userName),cb.equal(root.get("userPassword"), userPassword)));
		user=session.createQuery(cq).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
		/*return super.findByColumnAndId("userName", userName, "userPassword", userPassword);*/
	}

	
	

}

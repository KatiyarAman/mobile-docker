package com.mobiledocker.mobiledocker.DaoImpl;



import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.stereotype.Repository;

import com.mobiledocker.mobiledocker.Dao.BookUserDao;
import com.mobiledocker.mobiledocker.entity.BookUser;



@Repository("bookuserDao")
public class BookUserDaoImpl extends GenricRepositroyImpl<BookUser>  implements BookUserDao,InitializingBean {
  
	private static final Logger log=LoggerFactory.getLogger(BookUserDaoImpl.class);
	@Override
	public void BookUserDao(BookUser bookUser) {
		// TODO Auto-generated method stub
		log.info("Book user Dao"+bookUser);
	    Session session = getCurrentSession();
		
	        try {
	            session.beginTransaction();
	            session.save(bookUser);
	            log.info("Data saving :"+bookUser);
	            session.getTransaction().commit();
	            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	        finally {
	            session.close();
	        }
		    }

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		super.setEntity(BookUser.class);
	}

		

	}
	
	
		


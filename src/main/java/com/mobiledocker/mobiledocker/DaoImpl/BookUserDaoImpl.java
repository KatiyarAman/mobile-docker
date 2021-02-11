package com.mobiledocker.mobiledocker.DaoImpl;



import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.stereotype.Repository;

import com.mobiledocker.mobiledocker.Dao.BookUserDao;
import com.mobiledocker.mobiledocker.entity.BookUser;
import org.springframework.data.domain.Sort;


@Repository("bookuserDao")
public class BookUserDaoImpl extends GenricRepositroyImpl<BookUser>  implements BookUserDao,InitializingBean {
  
	private static final Logger log=LoggerFactory.getLogger(BookUserDaoImpl.class);
	private List<BookUser> bookUserList=new ArrayList<BookUser>();
	private BookUser  bookUser=new BookUser();
	
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

	@Override
	public List<BookUser> findBySortedCustomerId() {
		// TODO Auto-generated method stub
		bookUserList=null;
		log.info("Find By Sort CustomerId :");
		Session session=getCurrentSession();
		Transaction txn=null;
		try {txn=session.beginTransaction();
		bookUserList=session.createQuery("from BookUser").list();
		txn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			bookUserList = null;
			if(txn !=null) {
				txn.rollback();
			}
		}finally {
	    	session.close();
	    }
		return bookUserList;
	}

	@Override
	public BookUser findByColum(String customerId) {
		// TODO Auto-generated method stub
		return super.findByColumn("customerId", customerId);
	}

	@Override
	public BookUser get(String customerId) {
		// TODO Auto-generated method stub
		return super.findByColumn("customerId", customerId);
	}

		

	}
	
	
		


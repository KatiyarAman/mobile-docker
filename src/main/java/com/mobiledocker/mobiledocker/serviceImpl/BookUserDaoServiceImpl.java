package com.mobiledocker.mobiledocker.serviceImpl;



import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mobiledocker.mobiledocker.entity.*;
import com.mobiledocker.mobiledocker.repository.BookUserRepository;
import com.mobiledocker.mobiledocker.service.BookUserDaoService;

@Service
@Transactional
public class BookUserDaoServiceImpl implements BookUserDaoService {
   private static final Logger log=LoggerFactory.getLogger(BookUserDaoServiceImpl.class);
   
   @Autowired
   private BookUserRepository bookUserDao;
	
   @Override
	public void BookUser(BookUser bookUser) {
		// TODO Auto-generated method stub
		log.info("BookUserServiceImpl :"+bookUser);
		bookUserDao.BookUserDao(bookUser);
	}

}

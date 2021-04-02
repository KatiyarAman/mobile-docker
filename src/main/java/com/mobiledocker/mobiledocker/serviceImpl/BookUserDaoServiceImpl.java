package com.mobiledocker.mobiledocker.serviceImpl;


import com.mobiledocker.mobiledocker.entity.BookUser;
import com.mobiledocker.mobiledocker.entity.co.BookUserCo;
import com.mobiledocker.mobiledocker.entity.dto.BookUserDto;
import com.mobiledocker.mobiledocker.repository.BookUserRepository;
import com.mobiledocker.mobiledocker.service.BookUserDaoService;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.CustomerNotFoundException;
import com.mobiledocker.mobiledocker.util.exception.DiscoveryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookUserDaoServiceImpl implements BookUserDaoService {
    private static final Logger log = LoggerFactory.getLogger(BookUserDaoServiceImpl.class);

    private BookUser bookUserObj = new BookUser();

    private List<BookUser> bookUserList = new ArrayList<BookUser>();

    @Autowired
    private ObjectBinder objectBinder;

    @Autowired
    private BookUserRepository bookUserDao;

    @Override
    public void BookUser(BookUser bookUser) {
        // TODO Auto-generated method stub
        log.info("BookUserServiceImpl :" + bookUser);
        bookUserDao.BookUserDao(bookUser);
    }

    @Override
    public List<BookUserDto> findbySortedCustomerId() {

        bookUserList = bookUserDao.findBySortedCustomerId();
        if (bookUserList == null)
            throw new DiscoveryException("Please try again ..System is not able to communicate:");
        log.info("Getting List of Booking user:" + bookUserList.size());
        return objectBinder.bindBookUsers(bookUserList);
    }

    @Override
    public BookUserDto findByColum(String customerId) {
        // TODO Auto-generated method stub
        bookUserObj = bookUserDao.findByColum(customerId);
        if (bookUserObj == null)
            throw new CustomerNotFoundException("Entity not found by this customerId " + customerId);
        return objectBinder.bindBookUser(bookUserObj);
    }

    public BookUserDto updateStatus(BookUserCo bookUserCo, String customerId) {
        // TODO Auto-generated method stub
        log.info("Update in User Status :" + customerId);
        bookUserObj = bookUserDao.get(customerId);

        if (bookUserObj == null)
            throw new CustomerNotFoundException("Entity not found by this customerId " + customerId);
        bookUserObj.setId(bookUserObj.getId());
        bookUserObj.setCityname(bookUserCo.getCityname());
        bookUserObj.setCurrentstatus(bookUserCo.getCurrentstatus());
        bookUserObj.setDescrip(bookUserCo.getDescrip());
        bookUserObj.setSelectbrands(bookUserCo.getSelectbrands());
        bookUserObj.setSelectmodel(bookUserCo.getSelectmodel());
        bookUserObj.setFname(bookUserCo.getFname());
        bookUserObj.setMobilenumber(bookUserCo.getMobilenumber());
        bookUserObj.setReason(bookUserCo.getReason());
        bookUserObj.setZipcode(bookUserCo.getZipcode());
        System.out.println(bookUserObj.getId() + " " + bookUserCo.getCityname() + " " + bookUserCo.getCurrentstatus() + "" +
                bookUserCo.getMobilenumber() + " " + bookUserCo.getReason());
        BookUser bookupdateUser = bookUserDao.save(bookUserObj);

        return objectBinder.bindBookUser(bookupdateUser);
    }

    @Override
    public List<BookUserDto> SearchKeyword(String keywords) {
        // TODO Auto-generated method stub
        bookUserList = bookUserDao.findByMobilenumberContaining(keywords);
        if (bookUserList == null)
            throw new DiscoveryException("Please try again ..System is not able to communicate:");
        return objectBinder.bindBookUsers(bookUserList);
    }

}

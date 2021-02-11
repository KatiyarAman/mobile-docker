package com.mobiledocker.mobiledocker.Dao;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.BookUser;

public interface BookUserDao {
  public void BookUserDao(BookUser bookUser);
  public List<BookUser> findBySortedCustomerId();
  
  public BookUser findByColum(String customerId);
  public BookUser get(String customerId);
}

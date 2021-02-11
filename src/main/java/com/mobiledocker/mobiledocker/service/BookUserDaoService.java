package com.mobiledocker.mobiledocker.service;
import java.util.List;

import com.mobiledocker.mobiledocker.entity.*;
import com.mobiledocker.mobiledocker.entity.co.BookUserCo;
import com.mobiledocker.mobiledocker.entity.dto.BookUserDto;
public interface BookUserDaoService {
  
public List<BookUserDto> findbySortedCustomerId() ;

public void BookUser(BookUser bookUser);

public BookUserDto findByColum(String customerId);

public BookUserDto updateStatus(BookUserCo bookUserCo, String customerId);
}

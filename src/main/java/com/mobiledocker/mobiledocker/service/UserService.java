package com.mobiledocker.mobiledocker.service;

import java.util.List;

import com.mobiledocker.mobiledocker.entity.co.UserCo;
import com.mobiledocker.mobiledocker.entity.dto.UserDto;

public interface UserService {
public UserDto save(UserCo userCO);
public UserDto findByColumns(String userName,String userPassword);
public boolean isExist(String userName);
public List<UserDto> list();
}

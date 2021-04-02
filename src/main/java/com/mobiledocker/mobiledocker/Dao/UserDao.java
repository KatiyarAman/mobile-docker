package com.mobiledocker.mobiledocker.Dao;

import com.mobiledocker.mobiledocker.entity.User;

public interface UserDao extends GenericRepository<User>{
public User save(User user);
public User findByColumns(String userName,String userPassword);
}

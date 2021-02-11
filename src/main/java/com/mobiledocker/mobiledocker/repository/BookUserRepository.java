package com.mobiledocker.mobiledocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobiledocker.mobiledocker.Dao.BookUserDao;
import com.mobiledocker.mobiledocker.entity.BookUser;

public interface BookUserRepository extends JpaRepository<BookUser,Integer>,BookUserDao{

	

	

}

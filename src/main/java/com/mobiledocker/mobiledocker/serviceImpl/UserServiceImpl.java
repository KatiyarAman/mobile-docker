package com.mobiledocker.mobiledocker.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiledocker.mobiledocker.Dao.UserDao;
import com.mobiledocker.mobiledocker.entity.User;
import com.mobiledocker.mobiledocker.entity.co.UserCo;
import com.mobiledocker.mobiledocker.entity.dto.UserDto;
import com.mobiledocker.mobiledocker.service.UserService;
import com.mobiledocker.mobiledocker.util.ObjectBinder;
import com.mobiledocker.mobiledocker.util.exception.NotFoundException;
@Service
public class UserServiceImpl implements UserService{
@Autowired
private ObjectBinder objectBinder;
@Autowired
private UserDao userDao;
	@Override
	public UserDto save(UserCo userCO) {
		User user=new User(userCO.getUserName(),userCO.getUserEmail(),userCO.getUserPassword(),
				userCO.getUserMobile(),userCO.getUserCity(),userCO.getUserZipcode(),userCO.getUserRole());
		
		return objectBinder.bindUser(userDao.save(user));
	}

	@Override
	public UserDto findByColumns(String userName, String userPassword) {
		User user=userDao.findByColumns(userName, userPassword);
		if(user==null)
			throw new NotFoundException("User does not exist by userName: "+userName);
				return objectBinder.bindUser(user);
	}

	@Override
	public boolean isExist(String userName) {
		return userDao.findByColumn("userName", userName)!=null;
	}

	@Override
	public List<UserDto> list() {
		return objectBinder.bindUsers(userDao.list());
	}

}

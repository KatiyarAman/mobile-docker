package com.mobiledocker.mobiledocker.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mobiledocker.mobiledocker.Dao.UserDao;
import com.mobiledocker.mobiledocker.entity.User;
import com.mobiledocker.mobiledocker.util.exception.NotFoundException;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDao.findByColumn("userEmail",username);
		if(user==null)
			throw new NotFoundException("User not Exits");
		CustomUserDetails customUserDetails=new CustomUserDetails(user);
				return customUserDetails;
	}

}

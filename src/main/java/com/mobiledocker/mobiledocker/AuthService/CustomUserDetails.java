package com.mobiledocker.mobiledocker.AuthService;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mobiledocker.mobiledocker.entity.User;

public class CustomUserDetails implements UserDetails {
	private User user;

	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority(user.getUserRole());
		
		return Arrays.asList(simpleGrantedAuthority);
	}
	@Override
	public String getPassword() {
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
				return true;
	}

	@Override
	public boolean isAccountNonLocked() {
				return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
				return true;
	}

	@Override
	public boolean isEnabled() {
				return true;
	}

}

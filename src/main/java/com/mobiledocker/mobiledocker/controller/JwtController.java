package com.mobiledocker.mobiledocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobiledocker.mobiledocker.AuthService.CustomUserDetailsService;
import com.mobiledocker.mobiledocker.entity.JwtRequest;
import com.mobiledocker.mobiledocker.entity.JwtResponse;
import com.mobiledocker.mobiledocker.helper.JwtUtil;

@RestController
@CrossOrigin(origins="*")
public class JwtController {
	@Autowired
	private AuthenticationManager authenticationManger;
   @Autowired
   private CustomUserDetailsService cutomUserDetailsService;
   @Autowired
   private JwtUtil jwtUtil;
	
   @RequestMapping(value="/token",method=RequestMethod.POST)
   public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
	System.out.println(jwtRequest);
	try {
		this.authenticationManger
		.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getUserPassword()));
		
	} catch (UsernameNotFoundException e) {
		e.printStackTrace();
		throw new Exception("Bad credentials");
	}
	//fine area..
	UserDetails userDeatils=this.cutomUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
		String token=this.jwtUtil.generateToken(userDeatils);
		System.out.println("JWT :"+token);
		//{"token","value"}
	return ResponseEntity.ok(new JwtResponse(token));
   }
}

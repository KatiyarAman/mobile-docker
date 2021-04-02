package com.mobiledocker.mobiledocker.controller;
import io.swagger.annotations.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mobiledocker.mobiledocker.entity.co.UserCo;
import com.mobiledocker.mobiledocker.entity.dto.UserDto;
import com.mobiledocker.mobiledocker.service.UserService;
import com.mobiledocker.mobiledocker.util.exception.BadRequestException;
import com.mobiledocker.mobiledocker.util.exception.DuplicateRecordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins="*")
public class UserController {
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired  
	private BCryptPasswordEncoder passwordEncoder;
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto save(@RequestBody @Valid UserCo userCO, BindingResult bindingResult) {
		System.out.println("*********** :"+userCO.getUserName());
		userCO.setUserRole("ROLE_USER");
		userCO.setUserPassword(passwordEncoder.encode(userCO.getUserPassword()));
		if (bindingResult.hasErrors())
			throw new BadRequestException("Bad request Param missing");
		if(userService.isExist(userCO.getUserName()))
			throw new DuplicateRecordException("Username already exist by userName :"+userCO.getUserName());
	return userService.save(userCO);
	}
	/*@RequestMapping(value="/loginUser",method= {RequestMethod.POST,RequestMethod.GET},consumes = "application/json",produces="application/json")
	@CrossOrigin(origins="http://localhost:4200")
	public UserDto find(@RequestParam("userName")String userName,@RequestParam("userPassword")String userPassword
			@RequestBody UserCo userCO) {
		System.out.println(userName+" *******"+userPassword);
		return userService.findByColumns(userCO.getUserName(),userCO.getUserPassword());
			return userService.findByColumns(userName,userPassword);

		}*/
    @ApiResponses(@ApiResponse(code = 200, message = "OK"))
    @RequestMapping(value = "", method = RequestMethod.GET)	
    
    public List<UserDto>list(){
    	logger.info("Getting list of User :");
/*		return new ResponseEntity<>( userService.list(),HttpStatus.OK);
*/	return userService.list();
    	}
}

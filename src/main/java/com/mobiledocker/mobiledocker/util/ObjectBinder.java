package com.mobiledocker.mobiledocker.util;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobiledocker.mobiledocker.entity.BookUser;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.User;
import com.mobiledocker.mobiledocker.entity.dto.BookUserDto;
import com.mobiledocker.mobiledocker.entity.dto.CountryDto;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;
import com.mobiledocker.mobiledocker.entity.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectBinder {

    @Autowired
    private ModelMapper modelMapper;

 

    
    public CountryDto bindCountry(Country employee)
	  {
		      if(employee ==null)
			  return null;
		      CountryDto empDto=modelMapper.map(employee,CountryDto.class);			  
			  return empDto;
	  }
    public List<CountryDto> bindCountries(List<Country> brands)
    {
    	if(brands==null)
    		return new ArrayList<>();
    	List<CountryDto> countryDtoList=new ArrayList<CountryDto>();
    	brands.forEach(ed->{if(ed!=null)
    	 countryDtoList.add(new CountryDto(ed));	
    	});
    	return countryDtoList;
    }
    public StateDto bindState(State state) {
    	if(state == null)
    		return null;
    	StateDto stateDto=modelMapper.map(state,StateDto.class);
    		return stateDto;
    }
    public List<StateDto> bindStates(List<State> state){
    	if(state==null)
    		return new ArrayList<>();
    	List<StateDto> stateDtoList=new ArrayList<>();
    	state.forEach(ed->{if(ed !=null)stateDtoList.add(new StateDto(ed));}
    	);
    	return stateDtoList;
    }
    public BookUserDto bindBookUser(BookUser bookUser)
    {
    	if (bookUser ==null)
    		return null;
    	BookUserDto bookUserDto=modelMapper.map(bookUser, BookUserDto.class);
    	return bookUserDto;
    }
    public List<BookUserDto> bindBookUsers(List<BookUser> bookUsers){
    	
    	if(bookUsers ==null)
    		return new ArrayList<>();
    	List<BookUserDto> bookUserDto=new ArrayList<>();
    	 bookUsers.forEach(ed->{if(ed !=null)
    	    bookUserDto.add(new BookUserDto(ed));	 
    	 });
    	 return bookUserDto;
    }
    public MobileWareHouseDto bindWareHouse (MobileWarehouse warehouse)
    {
    	if(warehouse==null)
    		return null;
    	MobileWareHouseDto warehouseDto=modelMapper.map(warehouse, MobileWareHouseDto.class);
    	return warehouseDto;
    }
    public List<MobileWareHouseDto> bindWareHouses(List<MobileWarehouse> warehouses)
    {
    	if (warehouses ==null)
    		return new ArrayList<>();
    	List<MobileWareHouseDto> wareHousesDto= new ArrayList<>();
    	warehouses.forEach(ed->{
    		if(ed != null)
    			wareHousesDto.add(new MobileWareHouseDto(ed));
    	});
    	return wareHousesDto;
    }
   public UserDto bindUser(User user) {
    	if(user==null)
    		return null;
    	return modelMapper.map(user, UserDto.class);
    }
   public List<UserDto> bindUsers(List<User> users){
	   if(users==null)
		   return new ArrayList<>();
	   List<UserDto> userDtos=new ArrayList<>();
	   users.forEach(user->{
		   userDtos.add(bindUser(user));
	   });
	   return userDtos;
   }
	/*
	 * public StateJoinDto bindStatejoin(State state) { if (state==null) return
	 * null; StateJoinDto joindto=modelMapper.map(state,StateJoinDto.class); return
	 * joindto; } public List<StateJoinDto> bindstatejoin(List<State> states){
	 * if(states==null) return new ArrayList<>(); List<StateJoinDto> listjoin=new
	 * ArrayList<StateJoinDto>(); states.forEach(ed->{if(ed!=null) listjoin.add(new
	 * StateJoinDto(ed)); }); return listjoin; }
	 */
}

package com.mobiledocker.mobiledocker.util;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobiledocker.mobiledocker.entity.BookUser;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.dto.BookUserDto;
import com.mobiledocker.mobiledocker.entity.dto.CountryDto;
import com.mobiledocker.mobiledocker.entity.dto.MobileWareHouseDto;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;

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
}

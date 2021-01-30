package com.mobiledocker.mobiledocker.entity.dto;



import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.State;

public class StateDto {
	private Integer id;
	private Country country;
	private int brandId;
	private String name;
	
	
	public StateDto() {
		super();
	}
	public StateDto(State state) {
		//super();
		this.id = state.getId();
		this.country=state.getCountry();
		this.brandId=brandId;
		this.name = state.getName();
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
}

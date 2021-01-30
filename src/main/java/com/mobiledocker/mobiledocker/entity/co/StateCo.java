package com.mobiledocker.mobiledocker.entity.co;

import com.mobiledocker.mobiledocker.entity.Country;

public class StateCo {
	private Integer id;
	private int brandId;
	
	private String name;
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
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	
}

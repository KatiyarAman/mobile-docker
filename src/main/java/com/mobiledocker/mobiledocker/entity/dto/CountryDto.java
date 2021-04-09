package com.mobiledocker.mobiledocker.entity.dto;
import com.mobiledocker.mobiledocker.entity.Country;

public class CountryDto {
	
    private String brandName;
    private String brandId;		
	
	public CountryDto(String brandName, String brandId) {
		this.brandName = brandName;
		this.brandId = brandId;
	}
	public CountryDto() {
		super();
	}
	public CountryDto(Country country) {	
		this.brandName = country.getBrandName();
		this.brandId = country.getBrandId();		
	}
	public String getBrandName() {
		return brandName;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	

}

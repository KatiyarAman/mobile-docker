package com.mobiledocker.mobiledocker.entity.dto;
import com.mobiledocker.mobiledocker.entity.Country;

public class CountryDto {
	private Integer id;
	private String name;		
	public CountryDto(Integer id, String name) {		
		this.id = id;
		this.name = name;				
	}
	public CountryDto() {
		super();
	}
	public CountryDto(Country cy) {	
		this.id=cy.getId();
		this.name = cy.getName();		
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

}

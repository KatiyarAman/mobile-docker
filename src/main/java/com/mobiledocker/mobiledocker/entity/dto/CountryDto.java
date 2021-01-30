package com.mobiledocker.mobiledocker.entity.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.State;

public class CountryDto {
	private Integer id;
	private String name;
	private Set<State> states = new HashSet<State>(0);
	
	public CountryDto(Integer id, String name, Set<State> states) {
		
		this.id = id;
		this.name = name;
		this.states = states;
		
	}
	public CountryDto() {
		super();
	}
	public CountryDto(Country cy) {
	
		this.id=cy.getId();
		this.name = cy.getName();
		this.states=cy.getStates();
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
	public Set<State> getStates() {
		return states;
	}
	public void setStates(Set<State> states) {
		this.states = states;
	}
	
	
	
}

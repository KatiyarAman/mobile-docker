package com.mobiledocker.mobiledocker.entity.co;

import java.util.HashSet;
import java.util.Set;

import com.mobiledocker.mobiledocker.entity.State;

public class CountryCo {
	private Integer id;
	private String name;
	private Set<State> states = new HashSet<State>(0);
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

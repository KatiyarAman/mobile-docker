package com.mobiledocker.mobiledocker.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mobiledocker.mobiledocker.entity.co.StateCo;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name="state")
public class State implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Country country;
	private int brandId;
	private String name;
	private Set<City> cities = new HashSet<City>(0);
	
	@Column(name = "isDeleted")
	private boolean isDeleted = false;
   
	
	public State() {
     this.isDeleted=false;
	}

	public State(Country country, String name,int brandId) {
		this.country = country;
		this.name = name;
		this.brandId=brandId;
		
	}


	public State(Country country, String name, Set<City> cities) {
		this.country = country;
		this.name = name;
		this.cities = cities;
		
	}

	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "countryId")
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country i) {
		this.country = i;
	}

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

}

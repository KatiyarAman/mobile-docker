package com.mobiledocker.mobiledocker.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Table(name = "state")
public class State implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "model_id")
    private String modelId;
    @Column(name = "modelName", nullable = false, length = 250)
    private String modelName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_brand_id", nullable = false)
    private Country country; // one to one
    /* private Set<City> cities = new HashSet<City>(0); */

    @Column(name = "isDeleted")
    private boolean isDeleted = false;


    public State() {
        this.isDeleted = false;
        this.modelId=generateModelId();
    }

    /*public State(Country country, String modelName, String modelId) {
        this.country = country;
        this.modelName = modelName;
        this.modelId = generateModelId();

    }*/


    public State(String modelName, Country country) {
		
		this.modelName = modelName;
		this.country = country;
		this.isDeleted = false;
		this.modelId = generateModelId();
	}

	/*
     * public State(Country country, String name, Set<City> cities) { this.country =
     * country; this.name = name; this.cities = cities;
     *
     * }
     */
    private String generateModelId() {
        /* return "C-" + new Date().getTime();*/
     	LocalDateTime current = LocalDateTime.now();
         current.plus(5, ChronoUnit.MILLIS);
         return "MID-" + Date.from(current.toInstant(ZoneOffset.UTC)).getTime();
     }

    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country i) {
        this.country = i;
    }

    
   

    public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/*
     * @OneToMany(fetch = FetchType.LAZY, mappedBy = "state") public Set<City>
     * getCities() { return this.cities; }
     *
     * public void setCities(Set<City> cities) { this.cities = cities; }
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

}

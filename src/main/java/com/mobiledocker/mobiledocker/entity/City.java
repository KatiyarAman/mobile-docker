package com.mobiledocker.mobiledocker.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "city")
public class City implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private State state;

    private String name;
    @Column(name = "isDeleted")
    private boolean isDeleted = false;
    public City() {
    	this.isDeleted=false;
    }

    public City(State state, String name) {
        this.state = state;
        this.name = name;
        this.isDeleted=false;
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
    @JoinColumn(name = "stateId", nullable = false)
    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Column(name = "name", nullable = false, length = 250)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}


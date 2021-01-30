package com.mobiledocker.mobiledocker.entity.co;

import java.io.Serializable;

public class StateEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
    private int brandId;
	public StateEntity() {
	}

	public StateEntity(Integer id, String name,int brandId) {
		this.id = id;
		this.name = name;
		this.brandId=brandId;
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

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
}

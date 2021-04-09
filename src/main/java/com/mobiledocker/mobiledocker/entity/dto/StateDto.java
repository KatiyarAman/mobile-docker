package com.mobiledocker.mobiledocker.entity.dto;




import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.State;

public class StateDto {
	
	private String modelId;
	 private String modelName;
	 private Country country;
	 
	public StateDto() {
	}
	
	public StateDto(State state) {
		this.modelId = state.getModelId();
		this.modelName = state.getModelName();
		this.country=state.getCountry();
	}
	public String getModelId() {
		return modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	

	
}

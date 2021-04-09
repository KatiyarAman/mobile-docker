package com.mobiledocker.mobiledocker.entity.dto;

import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;
import com.mobiledocker.mobiledocker.entity.State;

public class MobileWareHouseDto {
	private String touchandlcd;
	private String touchscreenglass;
	private String battery;
	private String chargeport;
	private String loudspeaker;
	private String earspeaker;
	private String audiojack;
	private String microphone;
	private String network;
	private String softwarediagnosis;
	private String deadphonediagnosis;
	private String waterdiagnosis;
	private String standbyphone;
	private String warehouseId;
	private Country country;
	private State state ;
	/*@JsonProperty("registrationDate")
    private Date dateCreated;*/
	public MobileWareHouseDto(MobileWarehouse wareHouse) {
		this.touchandlcd = wareHouse.getTouchandlcd();
		this.touchscreenglass = wareHouse.getTouchscreenglass();
		this.battery = wareHouse.getBattery();
		this.chargeport = wareHouse.getChargeport();
		this.loudspeaker = wareHouse.getLoudspeaker();
		this.earspeaker = wareHouse.getEarspeaker();
		this.audiojack = wareHouse.getAudiojack();
		this.microphone = wareHouse.getMicrophone();
		this.network = wareHouse.getNetwork();
		this.softwarediagnosis = wareHouse.getSoftwarediagnosis();
		this.deadphonediagnosis = wareHouse.getDeadphonediagnosis();
		this.waterdiagnosis = wareHouse.getWaterdiagnosis();
		this.standbyphone = wareHouse.getStandbyphone();
		this.country=wareHouse.getCountry();
		this.state=wareHouse.getState();
		this.warehouseId=wareHouse.getWarehouseId();
	}
	
	public MobileWareHouseDto() {
		super();
	}

	public String getTouchandlcd() {
		return touchandlcd;
	}
	public void setTouchandlcd(String touchandlcd) {
		this.touchandlcd = touchandlcd;
	}
	public String getTouchscreenglass() {
		return touchscreenglass;
	}
	public void setTouchscreenglass(String touchscreenglass) {
		this.touchscreenglass = touchscreenglass;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getChargeport() {
		return chargeport;
	}
	public void setChargeport(String chargeport) {
		this.chargeport = chargeport;
	}
	public String getLoudspeaker() {
		return loudspeaker;
	}
	public void setLoudspeaker(String loudspeaker) {
		this.loudspeaker = loudspeaker;
	}
	public String getEarspeaker() {
		return earspeaker;
	}
	public void setEarspeaker(String earspeaker) {
		this.earspeaker = earspeaker;
	}
	public String getAudiojack() {
		return audiojack;
	}
	public void setAudiojack(String audiojack) {
		this.audiojack = audiojack;
	}
	public String getMicrophone() {
		return microphone;
	}
	public void setMicrophone(String microphone) {
		this.microphone = microphone;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getSoftwarediagnosis() {
		return softwarediagnosis;
	}
	public void setSoftwarediagnosis(String softwarediagnosis) {
		this.softwarediagnosis = softwarediagnosis;
	}
	public String getDeadphonediagnosis() {
		return deadphonediagnosis;
	}
	public void setDeadphonediagnosis(String deadphonediagnosis) {
		this.deadphonediagnosis = deadphonediagnosis;
	}
	public String getWaterdiagnosis() {
		return waterdiagnosis;
	}
	public void setWaterdiagnosis(String waterdiagnosis) {
		this.waterdiagnosis = waterdiagnosis;
	}
	public String getStandbyphone() {
		return standbyphone;
	}
	public void setStandbyphone(String standbyphone) {
		this.standbyphone = standbyphone;
	}
	
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	/*public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}*/

	public Country getCountry() {
		return country;
	}

	public State getState() {
		return state;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setState(State state) {
		this.state = state;
	}

}

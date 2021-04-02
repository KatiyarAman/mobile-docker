package com.mobiledocker.mobiledocker.entity.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mobiledocker.mobiledocker.entity.MobileWarehouse;

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
	private String brandName;
	private String seriesName;
	private String brand;
	private String brandseries ;
	private String warehouseId;
	@JsonProperty("registrationDate")
    private Date dateCreated;
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
		this.brandName = wareHouse.getBrandName();
		this.seriesName = wareHouse.getSeriesName();
		this.brand = wareHouse.getBrand();
		this.brandseries = wareHouse.getBrandseries();
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
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrandseries() {
		return brandseries;
	}

	public void setBrandseries(String brandseries) {
		this.brandseries = brandseries;
	}
}

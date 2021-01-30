package com.mobiledocker.mobiledocker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="MobileWarehouse")
@Entity
public class MobileWarehouse implements java.io.Serializable {

	@Id
	private int id;
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
	private int brand;
	@Column(name="brandseries")
	private int brandseries ;
	  @Column(name = "isDeleted")
	    private boolean isDeleted = false;
	   
	  private String warehouseId;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(updatable = false, nullable = false)
	    @org.hibernate.annotations.CreationTimestamp
	    private Date dateCreated;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(updatable = true)
	    @org.hibernate.annotations.UpdateTimestamp
	    private Date lastModified;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(updatable = false)
	    private Date dateDeleted;

	    public MobileWarehouse() {
	        this.warehouseId = generatewarehouseId();
	        this.isDeleted = false;
	    }
	 
	public MobileWarehouse( String touchandlcd, String touchscreenglass, String battery, String chargeport,
			String loudspeaker, String earspeaker, String audiojack, String microphone, String network,
			String softwarediagnosis, String deadphonediagnosis, String waterdiagnosis, String standbyphone, int brand,
			int brandseries, boolean isDeleted, String warehouseId, Date dateCreated, Date lastModified,
			Date dateDeleted,String seriesName,String brandName) {
		super();
		
		this.touchandlcd = touchandlcd;
		this.touchscreenglass = touchscreenglass;
		this.battery = battery;
		this.chargeport = chargeport;
		this.loudspeaker = loudspeaker;
		this.earspeaker = earspeaker;
		this.audiojack = audiojack;
		this.microphone = microphone;
		this.network = network;
		this.softwarediagnosis = softwarediagnosis;
		this.deadphonediagnosis = deadphonediagnosis;
		this.waterdiagnosis = waterdiagnosis;
		this.standbyphone = standbyphone;
		this.brand = brand;
		this.brandseries = brandseries;
		this.isDeleted = false;
		this.warehouseId = generatewarehouseId();
		this.dateCreated = dateCreated;
		this.lastModified = lastModified;
		this.dateDeleted = dateDeleted;
		this.seriesName=seriesName;
		this.brandName=brandName;
	}
	private String generatewarehouseId() {
        return "C-" + new Date().getTime();
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getBrand() {
		return brand;
	}
	public void setBrand(int brand) {
		this.brand = brand;
	}
	public int getBrandseries() {
		return brandseries;
	}
	public void setBrandseries(int brandseries) {
		this.brandseries = brandseries;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public Date getDateDeleted() {
		return dateDeleted;
	}
	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
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
	@Override
	public String toString() {
		return "MobileWarehouse [id=" + id + ", touchandlcd=" + touchandlcd + ", touchscreenglass=" + touchscreenglass
				+ ", battery=" + battery + ", chargeport=" + chargeport + ", loudspeaker=" + loudspeaker
				+ ", earspeaker=" + earspeaker + ", audiojack=" + audiojack + ", microphone=" + microphone
				+ ", network=" + network + ", softwarediagnosis=" + softwarediagnosis + ", deadphonediagnosis="
				+ deadphonediagnosis + ", waterdiagnosis=" + waterdiagnosis + ", standbyphone=" + standbyphone
				+ ", brandName=" + brandName + ", seriesName=" + seriesName + ", brand=" + brand + ", brandseries="
				+ brandseries + ", isDeleted=" + isDeleted + ", warehouseId=" + warehouseId + ", dateCreated="
				+ dateCreated + ", lastModified=" + lastModified + ", dateDeleted=" + dateDeleted + "]";
	}

	
}

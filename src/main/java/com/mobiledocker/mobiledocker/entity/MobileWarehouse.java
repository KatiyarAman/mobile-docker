package com.mobiledocker.mobiledocker.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Table(name = "MobileWarehouse")
@Entity
public class MobileWarehouse implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FK_model_id",nullable=false)
    private State state;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FK_brand_id",nullable=false)
    private Country country;

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

    /*public MobileWarehouse(String touchandlcd, String touchscreenglass, String battery, String chargeport,
                           String loudspeaker, String earspeaker, String audiojack, String microphone, String network,
                           String softwarediagnosis, String deadphonediagnosis, String waterdiagnosis, String standbyphone,
                           Country country,State state ) { */
                              
       /* this.touchandlcd = touchandlcd;
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
        this.country = country;
        this.state = state;
        this.isDeleted = false;
        this.warehouseId = generatewarehouseId();
    }*/


   


	public MobileWarehouse(String touchandlcd, String touchscreenglass, String battery, String chargeport,
			String loudspeaker, String earspeaker, String audiojack, String microphone, String network,
			String softwarediagnosis, String deadphonediagnosis, String waterdiagnosis, String standbyphone,
			Country country, State state) {
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
        this.country = country;
        this.state = state;
        this.isDeleted = false;
        this.warehouseId = generatewarehouseId();
	}

	private String generatewarehouseId() {
        /* return "C-" + new Date().getTime(); */
    	LocalDateTime current = LocalDateTime.now();
        current.plus(5, ChronoUnit.MILLIS);
        return "W-" + Date.from(current.toInstant(ZoneOffset.UTC)).getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

	public State getState() {
		return state;
	}

	public Country getCountry() {
		return country;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}

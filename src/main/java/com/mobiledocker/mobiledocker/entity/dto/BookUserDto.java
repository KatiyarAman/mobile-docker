package com.mobiledocker.mobiledocker.entity.dto;

import java.util.Date;

import com.mobiledocker.mobiledocker.entity.BookUser;

public class BookUserDto {
	private String mobilenumber;
	private String selectbrands;
	private String selectmodel;
	private String descrip;
	private String reason;
	private String zipcode;
	private String cityname;
	private String fname;
	private Date dateCreated;
	private String currentstatus;
	private String customerId;
	public BookUserDto(BookUser bookUser) {
		this.mobilenumber = bookUser.getMobilenumber();
		this.selectbrands = bookUser.getSelectbrands();
		this.selectmodel = bookUser.getSelectmodel();
		this.descrip = bookUser.getDescrip();
		this.reason = bookUser.getReason();
		this.zipcode = bookUser.getZipcode();
		this.cityname = bookUser.getCityname();
		this.fname = bookUser.getFname();
		this.dateCreated=bookUser.getDateCreated();
		this.currentstatus=bookUser.getCurrentstatus();
		this.customerId=bookUser.getCustomerId();
	}
	
	
	public BookUserDto() {
		super();
	}


	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getSelectbrands() {
		return selectbrands;
	}
	public void setSelectbrands(String selectbrands) {
		this.selectbrands = selectbrands;
	}
	public String getSelectmodel() {
		return selectmodel;
	}
	public void setSelectmodel(String selectmodel) {
		this.selectmodel = selectmodel;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getCurrentstatus() {
		return currentstatus;
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}

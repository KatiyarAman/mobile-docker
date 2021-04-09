package com.mobiledocker.mobiledocker.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Date;


@Entity
@Table(name = "book_user")
public class BookUser implements java.io.Serializable {
    @Id
    private int id;

    private String mobilenumber;

    private String selectbrands;

    private String selectmodel;

    private String descrip;

    private String reason;

    private String zipcode;

    private String cityname;

    private String currentstatus;

    @NotBlank(message = "Name can not be empty ..")
    @Size(min = 3, max = 10, message = "Name must be between 3-10 characters")
    private String fname;

    @Column(name = "isDeleted")
    private boolean isDeleted = false;

    private String customerId;

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

    public BookUser() {
        this.customerId = generateCustomerId();
        this.isDeleted = false;

    }


    public BookUser(String mobilenumber, String selectbrands, String selectmodel, String descrip, String reason,
                    String zipcode, String cityname, String fname, String currentstatus) {
        super();
        this.mobilenumber = mobilenumber;
        this.selectbrands = selectbrands;
        this.selectmodel = selectmodel;
        this.descrip = descrip;
        this.reason = reason;
        this.zipcode = zipcode;
        this.cityname = cityname;
        this.fname = fname;
        this.currentstatus = currentstatus;
    }

    public BookUser(String mobilenumber, String selectbrands, String selectmodel, String descrip, String reason,
                    String zipcode, String cityname, String fname, boolean deleted, String customerId, String currentstatus) {
        super();
        this.mobilenumber = mobilenumber;
        this.selectbrands = selectbrands;
        this.selectmodel = selectmodel;
        this.descrip = descrip;
        this.reason = reason;
        this.zipcode = zipcode;
        this.cityname = cityname;
        this.fname = fname;
        this.isDeleted = false;
        this.customerId = generateCustomerId();
        this.currentstatus = currentstatus;
    }

    private String generateCustomerId() {
       /* return "C-" + new Date().getTime();*/
    	LocalDateTime current = LocalDateTime.now();
        current.plus(5, ChronoUnit.MILLIS);
        return "CUST-" + Date.from(current.toInstant(ZoneOffset.UTC)).getTime();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public String getCustomerId() {
        return customerId;
    }


    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getCurrentstatus() {
        return currentstatus;
    }


    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }

    public boolean isDeleted() {
        return isDeleted;
    }


    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }

    //comapartor
    public static Comparator<BookUser> CustomerIdComapartar = new Comparator<BookUser>() {

        public int compare(BookUser e1, BookUser e2) {
            return e1.getCustomerId().compareTo(e2.getCustomerId());
        }
    };
}

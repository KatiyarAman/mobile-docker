package com.mobiledocker.mobiledocker.entity;


import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;



@Entity
@Table(name = "country")
public class Country implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String brandName;
    
    @Column(name = "brand_id")
    private String brandId;
    

    @Column(name = "isDeleted")
    private boolean isDeleted = false;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "mobilewarehouse")
    //private List<MobileWarehouse>  mobilewarehouse1 = new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", updatable = false, nullable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    @org.hibernate.annotations.UpdateTimestamp
    private Date lastModified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_deleted", updatable = false)
    private Date dateDeleted;
    
    public Country() {
        this.isDeleted = false;
        this.brandId=generateBrandId();
        
    }

    public Country(String brandName) {
    	this.brandId=generateBrandId();
        this.isDeleted=false;
        this.brandName = brandName;
    }
     
	private String generateBrandId() {
        /* return "C-" + new Date().getTime();*/
		LocalDateTime current = LocalDateTime.now();
        current.plus(10, ChronoUnit.MILLIS);
        return "BID-" + Date.from(current.toInstant(ZoneOffset.UTC)).getTime();
     }
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isdeleted) {
        this.isDeleted = isdeleted;
    }
    @Column(name = "brandName", nullable = false, length = 250)
	public String getBrandName() {
		return brandName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
   

}

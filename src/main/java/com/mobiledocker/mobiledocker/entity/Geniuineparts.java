package com.mobiledocker.mobiledocker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="genuineparts")
public class Geniuineparts {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
   private String name;
   private String partcode;
   private String price;
public Integer getId() {
	return id;
}
public String getName() {
	return name;
}
public String getPrice() {
	return price;
}
public void setId(Integer id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setPrice(String price) {
	this.price = price;
}
public String getPartcode() {
	return partcode;
}
public void setPartcode(String partcode) {
	this.partcode = partcode;
}
public Geniuineparts(String name, String partcode, String price) {
	//super();
	this.name = name;
	this.partcode = partcode;
	this.price = price;
}
public Geniuineparts(Integer id, String name, String partcode, String price) {
	//super();
	this.id = id;
	this.name = name;
	this.partcode = partcode;
	this.price = price;
}
public Geniuineparts() {
	//super();
}
@Override
public String toString() {
	return "Geniuineparts [id=" + id + ", name=" + name + ", partcode=" + partcode + ", price=" + price + "]";
}
   
   
}

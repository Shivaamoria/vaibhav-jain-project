package com.Food.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="customer")

public class Customer {
	@Id
	int id;
String tquery;
String cname;
String email;
String phone;
String enquiry;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTquery() {
	return tquery;
}
public void setTquery(String tquery) {
	this.tquery = tquery;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public String getEnquiry() {
	return enquiry;
}
public void setEnquiry(String enquiry) {
	this.enquiry = enquiry;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", tquery=" + tquery + ", cname=" + cname + ", email=" + email + ", phone=" + phone
			+ " enquiry=" + enquiry + "]";
}
public Customer(int id, String tquery, String cname, String email, String phone,  String enquiry) {
	super();
	this.id = id;
	this.tquery = tquery;
	this.cname = cname;
	this.email = email;
	this.phone = phone;
	
	this.enquiry = enquiry;
}
public Customer() {
	
}

}

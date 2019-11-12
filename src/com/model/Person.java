package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Person {
	private int id;
	private String name;
	private int level;
	private String lename;
	private String fname;private String lname;private String address;
	private String email;private String phonenumber;private String levelname;
	public  Person(int id ,String name) {
		setId(id);
		setName(name);
	}
	public Person(int id, String name, int level, String lname) {
		setId(id);
		setName(name);
		setLevel(level);
		setLename(lname);
		
	}
	public Person(String fname, String lname, String address, String email, String phonenumber, String level) {
	setFname(fname);
	setLname(lname);
	setAddress(address);
	setEmail(email);
	setPhonenumber(phonenumber);
	setLevelname(level);

	}
	public void setLevelname(String levelname) {
	this.levelname=levelname;	
	}
	public void setPhonenumber(String phonenumber) {
	this.phonenumber=phonenumber;
	}
	public void setEmail(String email) {
	this.email=email;	
	}
	public void setAddress(String address) {
	this.address=address;	
	}
	public void setLname(String lname) {
	this.lname=lname;	
	}
	public void setFname(String fname) {
	this.fname=fname;
	}

	public String getLevelname() {
	return levelname;	
	}
	public String getPhonenumber() {
	return phonenumber;	
	}
	public String getEmail() {
	return email;	
	}
	public String getAddress() {
	return address;	
	}
	public String getLname() {
	return lname;	
	}
	public String getFname() {
		return fname;
	}
	public void setLename(String lename) {
	this.lename=lename;	
	}
	public String getLename(){
		return lename;
		
	}
	public void setLevel(int level) {
	this.level=level;
	}
	public int getLevel(){
	     return level;	
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
}

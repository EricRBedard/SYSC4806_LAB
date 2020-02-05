package com.myApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String name;
    private String address;
    private int phoneNumber;
    private int age = -1;

	public BuddyInfo(String n, String a, int p) {
		this.name = n;
		this.address = a;
		this.phoneNumber = p;
	}

	public BuddyInfo(){ }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int a) {
		this.age = a;
	}

	public void setId(Long id){ this.id = id; }

	public Long getId(){ return id; }

	@Override
	public String toString() {
		return "Id: " + id + " Name: " + name + " Address: " + address + " Phone: " + phoneNumber;
	}
	
	public Boolean equals(BuddyInfo b) {
		if(phoneNumber == b.getPhoneNumber()) {
			if(name.equals(b.getName())) {
			    return address.equals(b.getAddress());
			}
		}
		return false;
	}
}

package com.example.demo.Model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String firstName;
	public String LastName;
	public String Email;
	public String Mobile;
	public String Address;
	public String City;
	public String State;
	public String Pincode;
	public LocalDateTime CreatedOn;
	public LocalDateTime lastModefiedOn;
	public String version;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	
	public LocalDateTime getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		CreatedOn = createdOn;
	}
	public LocalDateTime getLastModefiedOn() {
		return lastModefiedOn;
	}
	public void setLastModefiedOn(LocalDateTime lastModefiedOn) {
		this.lastModefiedOn = lastModefiedOn;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	public UserModel(String firstName, String lastName, String email, String mobile, String address, String city,
			String state, String pincode, LocalDateTime createdOn, LocalDateTime lastModefiedOn, String version) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		Email = email;
		Mobile = mobile;
		Address = address;
		City = city;
		State = state;
		Pincode = pincode;
		CreatedOn = createdOn;
		this.lastModefiedOn = lastModefiedOn;
		this.version = version;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UsersDTO [firstName=" + firstName + ", LastName=" + LastName + ", Email=" + Email + ", Mobile=" + Mobile
				+ ", Address=" + Address + ", City=" + City + ", State=" + State + ", Pincode=" + Pincode
				+ ", CreatedOn=" + CreatedOn + ", lastModefiedOn=" + lastModefiedOn + ", version=" + version + "]";
	}

}

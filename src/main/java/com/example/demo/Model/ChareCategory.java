package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@Entity
public class ChareCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String catagery;
	public String charedescription;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatagery() {
		return catagery;
	}
	public void setCatagery(String catagery) {
		this.catagery = catagery;
	}
	public String getCharedescription() {
		return charedescription;
	}
	public void setCharedescription(String charedescription) {
		this.charedescription = charedescription;
	}
	
	@Override
	public String toString() {
		return "ChareCategory [id=" + id + ", chare=" + catagery + ", charedescription=" + charedescription + "]";
	}
	public ChareCategory(int id, String chare, String charedescription) {
		super();
		this.id = id;
		this.catagery = chare;
		this.charedescription = charedescription;
	}
	public ChareCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

}

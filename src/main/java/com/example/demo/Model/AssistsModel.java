package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AssistsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String name;
	public String purchasedata;
	public String condition;
	public String assigned;
	public String recovered;
	public String status;
	public String category;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurchasedata() {
		return purchasedata;
	}
	public void setPurchasedata(String purchasedata) {
		this.purchasedata = purchasedata;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getAssigned() {
		return assigned;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AssistsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssistsModel(String name, String purchasedata, String condition, String assigned, String recovered,
			String status,String category) {
		super();
		this.category=category;
		this.name = name;
		this.purchasedata = purchasedata;
		this.condition = condition;
		this.assigned = assigned;
		this.recovered = recovered;
		this.status = status;
	}
	@Override
	public String toString() {
		return "AssietsDto [name=" + name + ", purchasedata=" + purchasedata + ", condition=" + condition
				+ ", assigned=" + assigned + ", recovered=" + recovered + ", status=" + status + "]";
	}


}

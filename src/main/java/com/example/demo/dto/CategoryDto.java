package com.example.demo.dto;

public class CategoryDto {
	
		
	public String category;
	public String categorydescription;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategorydescription() {
		return categorydescription;
	}
	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	@Override
	public String toString() {
		return "CategoryDto [category=" + category + ", categorydescription=" + categorydescription + "]";
	}
	public CategoryDto(String category, String categorydescription) {
		super();
		this.category = category;
		this.categorydescription = categorydescription;
	}
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

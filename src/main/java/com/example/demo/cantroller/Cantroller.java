package com.example.demo.cantroller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ChareCategory;

import com.example.demo.dto.CategoryDto;
import com.example.demo.CategoryRepository.CategoryRepository;


@RestController
public class Cantroller {
	
	@Autowired
	CategoryRepository CategoryRepository;
	
	
	JSONObject json=new JSONObject();

	
	@PostMapping(path="/categorys",produces="application/json")
	public String category(@RequestBody CategoryDto categorys) {
		
		String category=categorys.getCategory();
		String categorydescreption=categorys.getCategorydescription();
		
		ChareCategory cate=new ChareCategory();
		
		cate.setCatagery(category);
		cate.setCharedescription(categorydescreption);
		
		
		CategoryRepository.save(cate);
	
		json.put("status", "category is saved");
		return json.toString();	
		

		
	}
	
	@GetMapping(path="/lestcategories", produces="application/json")
	public String getlist() {
		
		JSONArray s=new JSONArray();
		List<ChareCategory> list=CategoryRepository.findAll();
	
		s.put(list);
		return s.toString();
				
	}
	
	@PostMapping(path="/updatecategories", produces="application/json")
	public String updatecategories(@RequestBody CategoryDto categorys) {
		
		String category=categorys.getCategory();
		String categorydescreption=categorys.getCategorydescription();
		
		try {
			Optional<ChareCategory> findBycatagery = CategoryRepository.findBycatagery(category);
			if(findBycatagery.isPresent()) {
				
				ChareCategory chareCategory = findBycatagery.get();
				chareCategory.setCatagery(category);
				chareCategory.setCharedescription(categorydescreption);
				CategoryRepository.save(chareCategory);
				
				json.put("status", "category is updated");
				return json.toString();	
				

			}
			else {
				ChareCategory chareCategory=new ChareCategory();
				chareCategory.setCatagery(category);
				chareCategory.setCharedescription(categorydescreption);			
				CategoryRepository.save(chareCategory);
				
				json.put("status", "category is Not present it is saved");
				return json.toString();	
				
			}
			
		}
		catch(Exception e){
			
			ChareCategory chareCategory=new ChareCategory();
			chareCategory.setCatagery(category);
			chareCategory.setCharedescription(categorydescreption);			
			CategoryRepository.save(chareCategory);
			
			json.put("status", "category is Not present it is saved");
			return json.toString();	
		}
				

	}
	
	
}

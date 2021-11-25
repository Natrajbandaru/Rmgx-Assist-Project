package com.example.demo.CategoryRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.Model.AssistsModel;
import com.example.demo.Model.ChareCategory;

@Component
public interface AssistRepository extends JpaRepository<AssistsModel, Serializable> {
	
	//AssistsModel findByname(String name);
	
	Optional<AssistsModel> findBycategory(String name);
	
	Optional<AssistsModel> findByname(String name);


  
}

package com.example.demo.CategoryRepository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.Model.AssistsModel;
import com.example.demo.Model.ChareCategory;


@Component
public interface CategoryRepository extends JpaRepository<ChareCategory, Serializable> {

	Optional<ChareCategory> findBycatagery(String name);

}

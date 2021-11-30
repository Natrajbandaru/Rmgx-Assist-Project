package com.example.demo.CategoryRepository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.Model.UserModel;

@Component
public interface UserSaveingRepository extends CrudRepository<UserModel, Serializable>{

}

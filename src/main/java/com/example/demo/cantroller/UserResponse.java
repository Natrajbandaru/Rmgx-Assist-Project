package com.example.demo.cantroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.UserModel;
import com.example.demo.Service.InterfaseService;
import com.example.demo.Validations.Validations;
import com.example.demo.dto.UsersDTO;



@RestController
public class UserResponse {
	
	@Autowired
	InterfaseService serviceinterfase;
	
	@Autowired
	Validations validation;
	
	
	@PostMapping(path="/addinguser",produces="application/json")
	public String UserData(@RequestBody UsersDTO userdata) {
		
		String uservalidations = validation.validation(userdata);
		
		if(uservalidations.equals("{}")) {
			
			String userResponseService = serviceinterfase.UserResponseService(userdata);
			System.out.println(userdata.toString());
			return userResponseService.toString();
			
		}
		else {
			return uservalidations.toString();
		}
		
	}
	
	@PostMapping(path="/getusers",produces = "application/json")
	public List<UserModel> getUsers() {
		
		List<UserModel> userService = serviceinterfase.getUserService();
		
		return userService;
	}
	
	@PostMapping(path="/size",produces = "application/json")
	public String SizeofUsers() {
		
		String userService = serviceinterfase.sizeofUsers();
		
		
		return userService.toString();
	}

	

}

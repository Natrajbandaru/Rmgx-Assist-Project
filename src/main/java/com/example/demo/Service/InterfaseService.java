package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.UserModel;
import com.example.demo.dto.UsersDTO;

@Component
public interface InterfaseService {
	
	public String UserResponseService(UsersDTO userdata);
	
	public List<UserModel> getUserService();
	
	public String sizeofUsers();
	

}

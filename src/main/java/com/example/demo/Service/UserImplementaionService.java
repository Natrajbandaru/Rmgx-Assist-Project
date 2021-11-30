package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Model.UserModel;
import com.example.demo.dto.UsersDTO;
import com.example.demo.CategoryRepository.UserSaveingRepository;

@Component
public class UserImplementaionService implements InterfaseService{
	
	@Autowired
	UserSaveingRepository UserSaveingRepository;
	
	JSONObject jsonresponse=new JSONObject();
	

	@Override
	public String UserResponseService(UsersDTO userdata) {
		
		UserModel datastore =new UserModel();
		
		datastore.setFirstName(userdata.getFirstName());
		datastore.setLastName(userdata.getLastName());
		datastore.setEmail(userdata.getEmail());
		datastore.setMobile(userdata.getMobile());
		datastore.setAddress(userdata.getAddress());
		datastore.setCity(userdata.getCity());
		datastore.setState(userdata.getState());
		datastore.setPincode(userdata.getPincode());
		
		
		LocalDateTime createdon=LocalDateTime.now();
		datastore.setCreatedOn(createdon);
		
		
		datastore.setLastModefiedOn(userdata.getLastModefiedOn());
		datastore.setVersion(userdata.getVersion());
		
		
		UserSaveingRepository.save(datastore);
		
		jsonresponse.put("status", "DataSaved");
		
		return jsonresponse.toString();
	}


	@Override
	public List<UserModel> getUserService() {
		
		List<UserModel> findAll = (List<UserModel>) UserSaveingRepository.findAll();
		
		return findAll;
	}


	@Override
	public String sizeofUsers() {
		
		List<UserModel> findAll = (List<UserModel>) UserSaveingRepository.findAll();
		int size=findAll.size();
		System.out.println(size);
		String data=String.valueOf(size);
		
		jsonresponse.put("SizeOfList", data);
		
		return jsonresponse.toString();
	}

}

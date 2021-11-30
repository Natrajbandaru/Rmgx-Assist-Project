package com.example.demo.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UsersDTO;

@Component
public class Validations {

	
	public String validation(UsersDTO users) {
		
	//	String pincode=users.getPincode();
		
		JSONObject jsonobject=new JSONObject();
	    String messages="";
	    String status="{}";


	    if(users.getPincode().isBlank()) {

	        status="2001";
	        messages="PinCode is Blank";
	        
	        jsonobject.put("message", messages);
	        jsonobject.put("status", status);
	    }

	    if(!users.getPincode().isEmpty()){

	    	String regex = "^[1-9][0-9]{5}$";
	        Pattern q = Pattern.compile(regex);

	        Matcher m = q.matcher(users.getPincode());

	        if(m.matches()) {

	        }
	        else {
	            status="2001";
	            messages="Enterd PinCode is Invalied";
	            
	            jsonobject.put("message", messages);
	            jsonobject.put("status", status);

	        }


	    }

	    if(users.getMobile().isEmpty()) {
	        status="2002";
	        messages="Mobile Number Should Not Blank";
	        
	        jsonobject.put("message", messages);
	        jsonobject.put("status", status);



	    }
	    if(!users.getMobile().isEmpty()) {
	    	String regex = "((\\+*)((0[ -]*)*|((91 )*))((\\d{12})+|(\\d{10})+))|\\d{5}([- ]*)\\d{6}";
	        Pattern q=Pattern.compile(regex);
	        Matcher m=q.matcher(users.getMobile());

	        if(m.matches()) {

	        }
	        else {
	            status="2002";
	            messages="EnterdMoble Number is Invalied";
	            
	            jsonobject.put("message", messages);
	            jsonobject.put("status", status);

	        }
	    }
	    
	    if(users.getEmail().isEmpty()) {
	        status="2002";
	        messages="Email Should Not Be Blank";
	        
	        jsonobject.put("message", messages);
	        jsonobject.put("status", status);



	    }
	    
	    
	    if(!users.getEmail().isEmpty()){
	        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z-]+\\.)+[a-zA-Z]{2,6}$";
	        Pattern q = Pattern.compile(regex);
	        Matcher m = q.matcher(users.getEmail());
	        
	        if(m.matches()) {

	        }
	        else {
	            status="2003";
	            messages="Enterd Mail is Not Correct";
	            
	            jsonobject.put("message", messages);
	            jsonobject.put("status", status);
	        }


	    }
	    
	    
		return jsonobject.toString();
		
	}

}

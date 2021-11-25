package com.example.demo.cantroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CategoryRepository.AssistRepository;
import com.example.demo.CategoryRepository.CategoryRepository;
import com.example.demo.Model.AssistsModel;
import com.example.demo.Model.ChareCategory;
import com.example.demo.dto.AssietsDto;

@RestController
public class AsistsCantroller {

	@Autowired
	AssistRepository assist;
	

	@Autowired
	CategoryRepository CategoryRepository;

	JSONObject json=new JSONObject();

	@PostMapping(path="/addassits", produces="application/json")
	public String assits(@RequestBody AssietsDto assits) {

		String name=assits.getName();
		String purchasdate=assits.getPurchasedata();
		String condition=assits.getCondition();
		String status=assits.getStatus();
		String assigned=assits.getAssigned();
		String recovered=assits.getRecovered();
		String catagery=assits.getCategory();

		System.out.println(recovered);

		AssistsModel assit=new AssistsModel();
		assit.setName(name);
		assit.setAssigned(assigned);
		assit.setCondition(condition);
		assit.setPurchasedata(purchasdate);
		assit.setRecovered(recovered);
		assit.setStatus(status);
		assit.setCategory(catagery);

		assist.save(assit);
		json.put("status", "Assist Data is Saved");
		return json.toString();

	}


	@PostMapping(path="/findbyname", produces="application/json")
	public String assits1(@RequestBody AssietsDto name) {

		JSONArray s=new JSONArray();

		List<Object> namoe=new ArrayList<>();

		String name1=name.getName();
		Optional<AssistsModel> findByname = assist.findByname(name1);

		System.out.println(findByname);
		namoe.add(findByname);
		s.put(namoe);
		return s.toString();
	}

	@PostMapping(path="/assigning",produces="application/json")
	public String assigning(@RequestBody AssietsDto name) {

		//selected catagery is not avelabel
		
		
		
		
		String category=name.getCategory();
		String status=name.getStatus();
		String assigned=name.getAssigned();
		
		try {
			Optional<ChareCategory> findBycatagery = CategoryRepository.findBycatagery(category);

			Optional<AssistsModel> categorys = assist.findBycategory(category);

			AssistsModel s=categorys.get();
			s.setStatus(status);
			s.setAssigned(assigned);

			assist.save(s);
			
			json.put("status", "category assigned");
			return json.toString();		
			
		}
		catch(Exception e) {
			json.put("status", "Selected Category is not present");
			return json.toString();			
		}
		
	
	}


	@PostMapping(path="/recoverd")
	public String Recoverd(@RequestBody AssietsDto name) {

		String category=name.getCategory();
		String status=name.getStatus();
		String recoverd=name.getRecovered();
		try {
		Optional<ChareCategory> findBycatagery = CategoryRepository.findBycatagery(category);

		Optional<AssistsModel> categorys = assist.findBycategory(category);
		AssistsModel s=categorys.get();

		s.setStatus(status);
		s.setRecovered(recoverd);	

		assist.save(s);
		json.put("status", "category Recoverd");
		return json.toString();	
		}
		catch(Exception e) {
			json.put("status", "selected Category is not present");
			return json.toString();	
			
		}
		}

	@PostMapping(path="/delete", produces="application/json")
	public String Deletedata(@RequestBody AssietsDto name) {

		String n=name.getName();
		System.out.println(n);
		try {
			System.out.println("ob");

			Optional<AssistsModel> findByName = assist.findByname(n);

			System.out.println("of");
			int id=findByName.get().getId();
			String status=findByName.get().getStatus();

			int i=Integer.parseInt(status);

			System.out.println(findByName+"nmae");

			if(i==1) {
				json.put("status", "It is Assigned");
				return json.toString();
			}
			else {
				assist.deleteById(id);
				json.put("status", "Assest is Deleted");
				return json.toString();

			}
		}
		catch(Exception e) {
			json.put("status", "Name is Not Excest");
			return json.toString();
		}

	}
}

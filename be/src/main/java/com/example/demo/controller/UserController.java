package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	public UserRepository userRepository;
	
	@GetMapping(value = "/users")
	MappingJacksonValue getAllUsers() {
		
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("password");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", simpleBeanPropertyFilter);
		List<User> users = userRepository.findAll();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
		mappingJacksonValue.setFilters(filterProvider);
		
		return mappingJacksonValue;
	}

	@PostMapping(value = "/user/login")
	MappingJacksonValue login(@RequestBody User user) { 
		
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("password", "address", "district", "city");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", simpleBeanPropertyFilter);
		List<User> users = userRepository.findAll();
		System.out.print(user.getPassword());
		
		for(int i=0; i<users.size(); i++)
			if (users.get(i).getEmail().equals(user.getEmail()) && users.get(i).getPassword().equals(user.getPassword())) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users.get(i));
				mappingJacksonValue.setFilters(filterProvider);
				
				return mappingJacksonValue;
			}
		return null;
	}
	
	@PostMapping(value = "/user/register")
	public String createUser(@RequestBody User user) {
		User insertedUser = userRepository.insert(user);
		return "OK";
	}
	
	@PutMapping(value = "/user/update/{id}")
	public String updateUser(@PathVariable("id") String id, @RequestBody Map<String, Object> payload) {
		
		List<User> users = userRepository.findAll();
		//check isAdmin
		boolean isAd = false;
		for(int i=0; i<users.size(); i++)
			if (users.get(i).getId().equals(payload.get("idCurrent"))) {
				if (users.get(i).getIsAdmin()== true)
					isAd = true;
				break;
			}

		User user;
		if (isAd == true) {
			for(int i=0; i<users.size(); i++)
				if (users.get(i).getId().equals(id)) {
					users.get(i).setEmail(payload.get("email").toString());
					users.get(i).setName(payload.get("name").toString()); 
					users.get(i).setIsAdmin(Boolean.parseBoolean(payload.get("isAdmin").toString())); 
					break;
				}
		}else {
			for(int i=0; i<users.size(); i++)
				if (users.get(i).getId().equals(id)) {
					
					users.get(i).setName(payload.get("name").toString());
					users.get(i).setEmail(payload.get("email").toString());
					users.get(i).setAddress(payload.get("address").toString());
					users.get(i).setDistrict(payload.get("district").toString());
					users.get(i).setCity(payload.get("city").toString());
					users.get(i).setPassword(payload.get("password").toString());
					System.out.print(users.get(i).getAddress());
					break;
				}
		}
		
		userRepository.saveAll(users);
		return "OK";
	}
	
	@DeleteMapping(value = "/user/delete/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping(value = "/profile/{id}")
	MappingJacksonValue getProfile(@PathVariable("id") String id) {
		System.out.print(id);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("password");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", simpleBeanPropertyFilter);
		List<User> users = userRepository.findAll();
		
		for(int i=0; i<users.size(); i++)
			if(users.get(i).getId().equals(id)) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users.get(i));
				mappingJacksonValue.setFilters(filterProvider);
				return mappingJacksonValue;
			}
		return null;
	}
}

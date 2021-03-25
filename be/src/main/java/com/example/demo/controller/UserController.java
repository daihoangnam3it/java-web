package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public ProfileRepository profileRepository;
	
	@GetMapping(value = "/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	@PostMapping(value = "/user/login")
	public User login(@RequestBody User user) {
		List<User> listUser = userRepository.findAll();
		for(int i=0; i<listUser.size(); i++)
			if (listUser.get(i).getEmail().equals(user.getEmail()) && listUser.get(i).getPassword().equals(user.getPassword()))
				return listUser.get(i);
		return user; // ???

	}
	
	@PostMapping(value = "/user/register")
	public String createUser(@RequestBody User user) {
		User insertedUser = userRepository.insert(user);
		
		Profile profile = new Profile("", "", "", user.getId());
		Profile insertedProfile = profileRepository.insert(profile);
	
		return "OK";
	}
	

	@PutMapping(value = "/user/update")
	public String updateUser(@RequestBody User user) {
		User updatedUser = userRepository.save(user);
		return "OK";
	}
	
	@DeleteMapping(value = "/user/delete/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping(value = "/user/get-detail/{id}")
	public Optional<User> getDetail(String id) {
		return userRepository.findById(id);
	}
	
}

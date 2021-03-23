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
public class ProfileController {
	
	@Autowired
	public ProfileRepository profileRepository;
	
//	public void createProfile(@RequestBody Profile profile) {
//		Profile insertedProfile = profileRepository.insert(profile);
//	}
	
	@GetMapping(value = "/profile/{userId}")
	public String getProfile(@PathVariable("userId") String userId) {
		return profileRepository.findById(userId).get().getUserId();
	}
//	@PutMapping(value = "/user/update")
//	public String updateUser(@RequestBody User user) {
//		User updatedUser = userRepository.save(user);
//		return "OK";
//	}
//	
//	@DeleteMapping(value = "/user/delete/{id}")
//	public void deleteUser(@PathVariable("id") String id) {
//		userRepository.deleteById(id);
//	}
//	
//	@GetMapping(value = "/user/get-detail")
//	public Optional<User> getDetail(String id) {
//		return userRepository.findById(id);
//	}
	
}

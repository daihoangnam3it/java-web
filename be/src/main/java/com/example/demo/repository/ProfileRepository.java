package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Profile;
import com.example.demo.model.User;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

}
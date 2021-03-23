package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;
import com.example.demo.model.Product;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
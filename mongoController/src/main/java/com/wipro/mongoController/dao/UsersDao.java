package com.wipro.mongoController.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wipro.mongoController.model.Users;
@Repository
public interface UsersDao extends MongoRepository<Users, String> {
	Users findByUsername(String username);
	Users findByEmail(String email);
}

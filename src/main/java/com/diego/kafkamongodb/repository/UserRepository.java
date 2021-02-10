package com.diego.kafkamongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diego.kafkamongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

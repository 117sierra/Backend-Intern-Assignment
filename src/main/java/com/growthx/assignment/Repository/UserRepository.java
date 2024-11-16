package com.growthx.assignment.Repository;

import com.growthx.assignment.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String>{

    Optional<User> findByName(String name);

}

package com.growthx.assignment.Repository;

import com.growthx.assignment.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminRepository extends MongoRepository<Admin,String> {

    Optional<Admin> findByName(String username);

}

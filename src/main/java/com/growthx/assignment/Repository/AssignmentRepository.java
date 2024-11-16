package com.growthx.assignment.Repository;

import com.growthx.assignment.Entity.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment,String> {

    List<Assignment> findByAdminName(String name);
}

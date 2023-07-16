package com.practice.mongo.repositories;

import com.practice.mongo.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findEmployeeByName(String name);
}

package com.practice.mongo.services;

import com.practice.mongo.dto.CreateEmployeeDto;
import com.practice.mongo.exceptions.EmployeeNotFoundException;
import com.practice.mongo.models.Employee;
import com.practice.mongo.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("No employee found with id: " + id));
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name)
                .orElseThrow(() -> new EmployeeNotFoundException("No employee found with name: " + name));
    }

    public Employee createEmployee(CreateEmployeeDto createEmployeeDto) {
        return employeeRepository.save(toEmployee(createEmployeeDto));
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    private Employee toEmployee(CreateEmployeeDto createEmployeeDto) {
        return new Employee()
                .setName(createEmployeeDto.getName())
                .setBirthDate(createEmployeeDto.getBirthDate())
                .setGender(createEmployeeDto.getGender())
                .setExternal(createEmployeeDto.isExternal());
    }
}

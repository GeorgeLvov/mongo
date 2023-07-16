package com.practice.mongo.controllers;

import com.practice.mongo.dto.CreateCompanyDto;
import com.practice.mongo.models.Company;
import com.practice.mongo.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company getCompanyById(@PathVariable String id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@RequestBody CreateCompanyDto createCompanyDto) {
        return companyService.createCompany(createCompanyDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company updateCompany(@PathVariable String id, @RequestBody CreateCompanyDto createCompanyDto) {
        return companyService.updateCompany(id, createCompanyDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCompany(@PathVariable String id) {
        companyService.deleteCompany(id);
    }

    @PostMapping("/{id}/employees")
    @ResponseStatus(HttpStatus.OK)
    public Company addEmployeeToCompany(@PathVariable String id, @RequestBody List<String> employeeIds) {
        return companyService.addEmployeeToCompany(id, employeeIds);
    }
}

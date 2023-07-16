package com.practice.mongo.services;

import com.practice.mongo.dto.CreateCompanyDto;
import com.practice.mongo.exceptions.CompanyNotFoundException;
import com.practice.mongo.models.Company;
import com.practice.mongo.models.Employee;
import com.practice.mongo.repositories.CompanyRepository;
import com.practice.mongo.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final EmployeeRepository employeeRepository;


    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(String id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException("No company found wit id: " + id));
    }

    public Company createCompany(CreateCompanyDto createCompanyDto) {
        return companyRepository.save(toCompany(createCompanyDto));
    }

    public Company updateCompany(String id, CreateCompanyDto createCompanyDto) {
        Company company = getCompanyById(id);

        Company companyToUpdate = company
                .setAddress(createCompanyDto.getAddress())
                .setName(createCompanyDto.getName())
                .setAcronym(createCompanyDto.getAcronym());

        return companyRepository.save(companyToUpdate);
    }

    public void deleteCompany(String id) {
        companyRepository.deleteById(id);
    }

    public Company addEmployeeToCompany(String id, List<String> employeeIds) {
        Company companyToUpdate = getCompanyById(id);

        Set<Employee> employeesToAdd = employeeIds.stream()
                .map(employeeRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        companyToUpdate.setEmployees(employeesToAdd);

        return companyRepository.save(companyToUpdate);
    }

    private Company toCompany(CreateCompanyDto createCompanyDto) {
        return new Company()
                .setName(createCompanyDto.getName())
                .setAcronym(createCompanyDto.getAcronym())
                .setAddress(createCompanyDto.getAddress());
    }
}

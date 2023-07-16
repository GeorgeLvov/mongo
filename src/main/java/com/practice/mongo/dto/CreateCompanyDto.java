package com.practice.mongo.dto;

import com.practice.mongo.models.Address;
import lombok.Data;

@Data
public class CreateCompanyDto {

    private String name;

    private String acronym;

    private Address address;
}

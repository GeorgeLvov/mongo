package com.practice.mongo.dto;

import com.practice.mongo.models.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class CreateEmployeeDto {

    private String name;

    private Date birthDate;

    private Gender gender;

    private boolean isExternal;
}
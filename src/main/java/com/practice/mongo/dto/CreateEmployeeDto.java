package com.practice.mongo.dto;

import com.practice.mongo.models.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateEmployeeDto {

    private String name;

    private LocalDate birthDate;

    private Gender gender;

    private boolean isExternal;
}
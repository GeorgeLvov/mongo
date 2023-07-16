package com.practice.mongo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "companies")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseModel {

    @Field
    @Indexed(unique = true)
    private String name;

    @Field
    @Indexed(unique = true)
    private String acronym;

    private Address address;

    @DBRef
    private Set<Employee> employees = new HashSet<>();
}

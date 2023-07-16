package com.practice.mongo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Document(collection = "employees")
@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseModel {

    @Indexed
    private String name;

    @Field(name = "dateOfBirth")
    private Date birthDate;

    @Field(targetType = FieldType.STRING)
    private Gender gender;

    private boolean isExternal;
}

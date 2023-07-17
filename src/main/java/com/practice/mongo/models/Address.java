package com.practice.mongo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class Address {

    private String city;

    private String postalCode;

    private String street;
}

package com.student.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @NotEmpty(message ="Student city can not be empty")
    @Size(min=3,message = "Student city name must be have 3 digit")
    private String  city;
    @NotBlank(message ="Student state can not be empty")
    @Size(min=3,message = "Student city name must be have 3 digit")
    private String state;
    @NotEmpty(message ="Student country can not be empty")
    @Size(min=3,message = "Student country name must be have 3 digit")
    private String country;

}

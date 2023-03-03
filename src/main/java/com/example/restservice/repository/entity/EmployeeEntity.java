package com.example.restservice.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Yeming Hu
 * @Date: 3/1/2023
 * @Description: com.example.restservice.repository
 * @Version: 1.0
 */
//this class is a map of the table in db
@Setter
@Getter
@Builder
public class EmployeeEntity {
    private int id;
    private String name;
    private String postalCode;
    private double salary;
}

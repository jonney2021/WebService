package com.example.restservice.model;

import lombok.*;

/**
 * @Author: Yeming Hu
 * @Date: 2/24/2023
 * @Description: com.example.restservice.model
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Employee {
    private int id;
    private String name;
    private String postalCode;
    private double salary;
}

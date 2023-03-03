package com.example.restservice.model;

import lombok.*;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.model
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Person {
    private Long id;
    private String url;
    private String name;
    private String gender;
}

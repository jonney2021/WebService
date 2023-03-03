package com.example.restservice.dto.client;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.dto.client
 * @Version: 1.0
 */
@Getter
@Setter
public class PersonDTO {
    private Long id;
    private String url;
    private String name;
    private String gender;
}

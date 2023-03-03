package com.example.restservice.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.dto.out
 * @Version: 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonOutputDTO {
    private Long id;

    @JsonProperty("profile-url")
    private String url;

    @JsonProperty("actor-name")
    private String name;

    private String gender;
}

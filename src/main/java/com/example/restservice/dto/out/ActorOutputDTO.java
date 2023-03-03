package com.example.restservice.dto.out;

import com.example.restservice.model.Person;
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
public class ActorOutputDTO {

    private Double score;
    private PersonOutputDTO person;

}

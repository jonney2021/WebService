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
public class TVMaze {
    private Double score;
    private Person person;

}

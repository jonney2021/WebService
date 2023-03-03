package com.example.restservice.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.model
 * @Version: 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Joke {
    private String text;
    private LocalDateTime createdAt;
}

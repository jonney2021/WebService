package com.example.restservice.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class JokeDTO {
    @JsonProperty("icon_url")
    private String iconUrl;
    private String id;
    private String url;
    private String value;
    @JsonProperty("created_at")
    private String createdAt;
}

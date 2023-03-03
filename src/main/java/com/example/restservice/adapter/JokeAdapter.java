package com.example.restservice.adapter;

import com.example.restservice.dto.client.JokeDTO;
import com.example.restservice.dto.client.TVMazeDTO;
import com.example.restservice.model.Joke;
import com.example.restservice.model.Person;
import com.example.restservice.model.TVMaze;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.adapter
 * @Version: 1.0
 */
@Component
public class JokeAdapter {

//    @Value("${Joke.api.url}")
    @Value("${Joke.api.url}")
    private String url;

    private final RestTemplate restTemplate;

    public JokeAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public Joke getJoke(String category){
        JokeDTO jokeDTO = restTemplate.getForObject(url, JokeDTO.class,category);
        if(jokeDTO != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(
                    jokeDTO.getCreatedAt().substring(0,jokeDTO.getCreatedAt().indexOf('.')),formatter);

            return Joke.builder().text(jokeDTO.getValue())
                    .createdAt(dateTime)
                    .build();
        }
        return null;

//        URI uri = UriComponentsBuilder
//                .fromUri(URI.create(url))
//                .queryParam("q", category)
//                .build()
//                .toUri();
//
//        HttpEntity<JokeDTO> response = restTemplate.exchange(uri, HttpMethod.GET, null, JokeDTO.class);
//        JokeDTO responseDTO = response.getBody();
//        if (response != null) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            LocalDateTime dateTime = LocalDateTime.parse(
//                    responseDTO.getCreatedAt().substring(0,responseDTO.getCreatedAt().indexOf('.')),formatter);
//            return Joke.builder()
//                    .text(responseDTO.getValue())
//                    .createdAt(dateTime)
//                    .build();
//        }
//        return null;
    }
}

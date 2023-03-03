package com.example.restservice.adapter;

import com.example.restservice.dto.client.PersonDTO;
import com.example.restservice.dto.client.TVMazeDTO;
import com.example.restservice.model.Person;
import com.example.restservice.model.TVMaze;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.adapter
 * @Version: 1.0
 */
@Component
public class TVMazeAdapter {
//    @Value("${TVMaze.api.url}")
    @Value("${TVMaze.api.url}")
    private String url;

    private final RestTemplate restTemplate;

    @Autowired
    ModelMapper modelMapper;

    public TVMazeAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TVMaze getActor(String actorName) {
        URI uri = UriComponentsBuilder
                .fromUri(URI.create(url))
                .queryParam("q", actorName)
                .build()
                .toUri();

        HttpEntity<TVMazeDTO[]> response = restTemplate.exchange(uri, HttpMethod.GET, null, TVMazeDTO[].class);
        TVMazeDTO[] responseDTOList = response.getBody();
        if (responseDTOList != null) {
            TVMazeDTO responseDTO = responseDTOList[0];
//            return TVMaze.builder()
//                    .score(responseDTO.getScore())
//                    .person(Person.builder()
//                            .id(responseDTO.getPerson().getId())
//                            .url(responseDTO.getPerson().getUrl())
//                            .name(responseDTO.getPerson().getName())
//                            .gender(responseDTO.getPerson().getGender())
//                            .build())
//                    .build();
            return modelMapper.map(responseDTO,TVMaze.class);

        }
        return null;
    }

//        TVMazeDTO tvMazeDTO = restTemplate.getForObject(url, TVMazeDTO.class);
//        if(tvMazeDTO != null){
//            return TVMaze.builder()
//                    .score(tvMazeDTO.getScore())
//                    .person(Person.builder().id().name()).build();
//        }
//        return null;

}

package com.example.restservice.api;

import com.example.restservice.dto.out.ActorOutputDTO;
import com.example.restservice.dto.out.PersonOutputDTO;
import com.example.restservice.model.TVMaze;
import com.example.restservice.service.TVMazeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.api
 * @Version: 1.0
 */
@RestController
@RequestMapping("/jac")
public class TVMazeController {

    @Autowired
    private TVMazeService tvMazeService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/actor")
    public ResponseEntity<ActorOutputDTO> getActor(@RequestParam String actorName){
        TVMaze tvMaze = tvMazeService.getActor(actorName);
//        ActorOutputDTO response = ActorOutputDTO.builder()
//                .score(tvMaze.getScore())
//                .person(PersonOutputDTO
//                        .builder()
//                        .id(tvMaze.getPerson().getId())
//                        .url(tvMaze.getPerson().getUrl())
//                        .name(tvMaze.getPerson().getName())
//                        .gender(tvMaze.getPerson().getGender())
//                        .build()
//                        ).build();
        ActorOutputDTO response = modelMapper.map(tvMaze,ActorOutputDTO.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

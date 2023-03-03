package com.example.restservice.api;

import com.example.restservice.model.Joke;
import com.example.restservice.service.JokeService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.api
 * @Version: 1.0
 */
@RestController
@RequestMapping("/jac")
public class JokeController {
    @Autowired
    private JokeService jokeService;

    @GetMapping("/joke")
    public ResponseEntity<Joke> getJoke(@Nullable @RequestParam String category){
        return new ResponseEntity<>(jokeService.getJoke(category), HttpStatus.OK);
    }
}

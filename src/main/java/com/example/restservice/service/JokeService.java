package com.example.restservice.service;

import com.example.restservice.adapter.JokeAdapter;
import com.example.restservice.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.service
 * @Version: 1.0
 */
@Service
public class JokeService {

    @Autowired
    private JokeAdapter jokeAdapter;

    public Joke getJoke(String category){
        return jokeAdapter.getJoke(category);
    }
}

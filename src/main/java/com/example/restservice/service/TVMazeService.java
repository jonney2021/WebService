package com.example.restservice.service;

import com.example.restservice.adapter.TVMazeAdapter;
import com.example.restservice.model.TVMaze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Yeming Hu
 * @Date: 2/28/2023
 * @Description: com.example.restservice.service
 * @Version: 1.0
 */
@Service
public class TVMazeService {
    @Autowired
    private TVMazeAdapter tvMazeAdapter;

    public TVMaze getActor(String actorName){
        return tvMazeAdapter.getActor(actorName);
    }
}

package com.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dslist.dto.GameDTO;
import com.dslist.entities.Game;
import com.dslist.repositories.GameRepositories;

@Service
public class GameService {

    @Autowired
    private GameRepositories gameRepositories;

    public List<GameDTO> findAll() {
        List<Game> result = gameRepositories.findAll();
        return result.stream().map(x -> new GameDTO(x)).toList();
    }

}

package com.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dslist.dto.GameCompletoDTO;
import com.dslist.dto.GameDTO;
import com.dslist.entities.Game;
import com.dslist.repositories.GameRepositories;

@Service
public class GameService {

    @Autowired
    private GameRepositories gameRepositories;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        List<Game> result = gameRepositories.findAll();
        return result.stream().map(x -> new GameDTO(x)).toList();
    }


    @Transactional(readOnly = true)
    public GameCompletoDTO findById(Long id) {
        Game result = gameRepositories.findById(id).get();
        return new GameCompletoDTO(result);
    }

}

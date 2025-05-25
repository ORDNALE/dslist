package com.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dslist.dto.GameCompletoDTO;
import com.dslist.dto.GameDTO;
import com.dslist.entities.Game;
import com.dslist.projections.GameMinProjection;
import com.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameDTO(x)).toList();
    }


    @Transactional(readOnly = true)
    public GameCompletoDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameCompletoDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameDTO(x)).toList();
    }

}

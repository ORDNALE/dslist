package com.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dslist.dto.GameCompletoDTO;
import com.dslist.dto.GameDTO;
import com.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    
    @GetMapping
    public List<GameDTO> findAll() {
        List<GameDTO> list = gameService.findAll();
        return list;
    }

     @GetMapping(value = "/{id}")
    public GameCompletoDTO findById(@PathVariable Long id) {
        GameCompletoDTO list = gameService.findById(id);
        return list;
    }
    

}

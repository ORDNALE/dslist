package com.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dslist.dto.GameDTO;
import com.dslist.dto.GameListDTO;
import com.dslist.dto.ReplacementDTO;
import com.dslist.services.GameListService;
import com.dslist.services.GameService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;
    
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> list = gameListService.findAll();
        return list;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameDTO> findByList(@PathVariable Long listId) {
        List<GameDTO> list = gameService.findByList(listId);
        return list;
    }

    @PostMapping(value = "/{listId}/replacement")	
    public void move(@PathVariable Long listId,  @RequestBody ReplacementDTO body) {
        gameListService.move(listId,body.getSourceIndex(), body.getDestinationIndex());
    }

}

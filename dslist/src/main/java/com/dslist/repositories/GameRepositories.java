package com.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dslist.entities.Game;

public interface GameRepositories extends JpaRepository<Game, Long> {

}

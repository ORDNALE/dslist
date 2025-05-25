package com.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}

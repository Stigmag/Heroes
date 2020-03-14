package com.example.demo.service;



import com.example.demo.game.Game;
import com.example.demo.db.entity.GameTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameService {

   GameTable save(GameTable game);


   Optional<GameTable> getById(int id );

    void delete(int id);

    List<GameTable> getAll();




}

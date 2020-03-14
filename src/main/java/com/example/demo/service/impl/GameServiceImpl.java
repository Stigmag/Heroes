package com.example.demo.service.impl;


import com.example.demo.game.Game;
import com.example.demo.db.entity.GameTable;
import com.example.demo.db.repository.GameRepository;

import com.example.demo.service.GameService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @Override
    public GameTable save(GameTable game) {

        return gameRepository.saveAndFlush( game);
    }

    @Override
    public void delete(int id) {
        gameRepository.deleteById(id);

    }
@Override
    public Optional<GameTable> getById(int id) {
        return gameRepository.findById(id);
    }

    @Override
    public List<GameTable> getAll() {
        return gameRepository.findAll();
    }
}
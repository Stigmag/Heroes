package com.example.demo.db.repository;

import com.example.demo.db.entity.GameTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends JpaRepository<GameTable, Integer> {


}
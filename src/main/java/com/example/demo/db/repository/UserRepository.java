package com.example.demo.db.repository;

import com.example.demo.db.entity.UserTable;
import com.example.demo.game.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository  extends CrudRepository<UserTable, Integer> {

   Optional<UserTable> findByName  (String name);
}

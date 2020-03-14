package com.example.demo.db.repository;

import com.example.demo.db.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<UserTable, Integer> {
}

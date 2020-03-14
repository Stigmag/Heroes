package com.example.demo.db.repository;

import com.example.demo.db.entity.MyMapTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MapRepository extends JpaRepository<MyMapTable, UUID> {


}
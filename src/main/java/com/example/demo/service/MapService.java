package com.example.demo.service;



import com.example.demo.db.entity.MyMapTable;
import com.example.demo.map.MyMap;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MapService {

   MyMapTable save(MyMap myMap);


   Optional<MyMapTable> getById(UUID id);

    void delete(UUID id);

    List<MyMapTable> getAll();




}

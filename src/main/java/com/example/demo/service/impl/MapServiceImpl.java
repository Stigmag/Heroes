package com.example.demo.service.impl;


import com.example.demo.JsonParser;
import com.example.demo.db.entity.MyMapTable;
import com.example.demo.db.repository.MapRepository;
import com.example.demo.map.MyMap;
import com.example.demo.service.MapService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;

    public MapServiceImpl(MapRepository mapRepository) {
        this.mapRepository =mapRepository;
    }



    @Override
    public void delete(UUID id) {
        mapRepository.deleteById(id);

    }

    @Override
    public MyMapTable save(MyMap myMap) {
        return mapRepository.saveAndFlush( new MyMapTable(JsonParser.parseToJson(myMap),myMap.getMapId()));
    }

    @Override
    public Optional<MyMapTable> getById(UUID id) {
        return mapRepository.findById(id);
    }

    @Override
    public List<MyMapTable> getAll() {
        return mapRepository.findAll();
    }
}
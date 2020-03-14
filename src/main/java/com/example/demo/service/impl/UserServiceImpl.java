package com.example.demo.service.impl;


import com.example.demo.JsonParser;
import com.example.demo.game.User;
import com.example.demo.db.entity.UserTable;
import com.example.demo.db.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl( UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserTable save(User user) {

        return userRepository.saveAndFlush( new UserTable());
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);

    }
@Override
    public Optional<UserTable> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserTable> getAll() {
        return userRepository.findAll();
    }
}
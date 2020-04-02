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
    public UserTable save(UserTable user) {

        return userRepository.save(new UserTable(user.getName(),user.getPassword()));
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);

    }
@Override
    public Optional<UserTable> getByLogin(int name) {
        return userRepository.findById(name);
    }

    @Override
    public List<UserTable> getAll() {
        return (List<UserTable>) userRepository.findAll();
    }
}
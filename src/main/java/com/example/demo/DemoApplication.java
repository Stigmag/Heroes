package com.example.demo;


import com.example.demo.db.entity.UserTable;
import com.example.demo.db.repository.UserRepository;
import com.example.demo.game.Game;
import com.example.demo.game.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class  DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
Game game= new Game();
game.start();


	}


}

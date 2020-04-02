package com.example.demo.controller;





;

import com.example.demo.db.entity.MyMapTable;
import com.example.demo.db.entity.UserTable;
import com.example.demo.game.Game;
import com.example.demo.db.entity.GameTable;
import com.example.demo.game.User;
import com.example.demo.map.MyMap;
import com.example.demo.service.GameService;
import com.example.demo.service.MapService;
import com.example.demo.service.UserService;


import lombok.Data;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/db")
public class DBController {
    private final GameService gameService;
    private final MapService mapService;
    private final UserService userService;


    public DBController(GameService gameService, MapService mapService, UserService userService
    ) {
        this.gameService = gameService;
        this.mapService = mapService;
        this.userService = userService;

    }

    private MyMapTable mapTable;
    private GameTable gameTable;
    private UserTable user;




    @PostMapping("/save-game")
    public String addData(@RequestBody Game request) {

        gameTable = new GameTable(request.getMapFile());
       //gameTable.setUser(user);
        gameService.save(gameTable);


        return new DBResponse().text;
    }

    @PostMapping("/init-user")
    public String addUser(@RequestBody UserTable request) {

        user = userService.save(request);


        return new DBResponse().text;
    }

    @GetMapping ("/load-saved-game/{savedGameID}")
    public File loadGame( @PathVariable String savedGameID) throws Exception {

        GameTable gameTable=this.gameService.getById(Integer.parseInt(savedGameID)).orElseThrow(() -> new ResourceNotFoundException());

                File outputFile= new File("C:\\Users\\Kate\\Desktop\\Heroes_game_server\\data\\savedMap.txt");
        Files.write(outputFile.toPath(),gameTable.getMapFile());
            return outputFile ;
        }

    @Data
    public static class DBResponse {
        private String text = "ADD DATA";
    }


}

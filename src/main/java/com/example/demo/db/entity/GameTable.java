package com.example.demo.db.entity;

import com.example.demo.game.GameState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Game_Table")






public class GameTable implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int gameId;

    public byte[] getMapFile() {
        return mapFile;
    }

    @Column(name="map_file")
    private byte[] mapFile;

    public void setUser(UserTable user) {
        this.user.add(user) ;
    }



    @OneToMany(mappedBy = "game", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)

    private List<UserTable> user;



    public GameTable(byte[] mapFile) {

this.mapFile=mapFile;
    }

    public GameTable() {

    }
}

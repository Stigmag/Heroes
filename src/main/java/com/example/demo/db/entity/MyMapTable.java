package com.example.demo.db.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "MyMap_Table")


public class MyMapTable implements Serializable {


    @Id
    @Column(name = "mapId")
    private UUID mapId;





    @Column(name = "state_Map")
    private String stateMap;



    public MyMapTable(String stateMap, UUID mapID) {
        this.stateMap = stateMap;
        this.mapId = mapID;
    }

    public UUID getId() {
        return mapId;
    }







    public MyMapTable() {
    }
}


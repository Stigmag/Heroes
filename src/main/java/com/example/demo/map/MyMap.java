package com.example.demo.map;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MyMap {
private Building building;

    public  static  byte[] mapArray=
            {10,10,
                    11,11,11,11,11,11,11,11,11,11,
                    11,11,11,11,11,10,10,11,11,11,
                    11,11,10,10,10,10,10,10,11,11,
                    11,11,10,10,10,10,10,10,10,11,
                    11,11,10,10,10,10,10,10,10,11,
                    11,11,11,10,10,10,10,10,11,11,
                    11,11,11,11,11,10,11,11,11,11,
                    11,11,10,10,11,11,11,11,11,11,
                    11,11,11,11,11,11,11,11,11,11,
                    11,11,11,11,11,11,11,11,11,11,


            };

   private byte water=10;
    byte forest=0;
    byte mountains=1;

    public byte getRoad() {
        return road;
    }

    private  byte road=11;
    byte river=100;
    byte sand=101;
    byte meadow=110;
    byte swamp=111;
    byte place=(byte)1111;
    private UUID mapId;

    public MyMap() {
        this.mapId= UUID.randomUUID();

    }

    public UUID getMapId() {
        return mapId;
    }

    public  byte[][] getMapMatrix()
    {
        int size= mapArray.length;
        byte[][] matrix= new byte [mapArray[0]][mapArray[1]];
        int k=2;
        for(int i=0;i<mapArray[0];i++){
            for(int j=0;j<mapArray[1]; j++)
            {
                matrix[i][j]=mapArray[k];
                k++;
            }

        }
        return matrix;
    }
 public Point getStartPoint(){
        return new Point(0,0);

 }
public Point getFinnishPoint(){
        return new Point(5,10);
}
}


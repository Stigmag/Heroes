package com.example.demo.game;

import com.example.demo.game.Army;
import com.example.demo.game.GameState;
import com.example.demo.game.MoveEvent;
import com.example.demo.game.Ticker;
import com.example.demo.map.MyMap;
import com.example.demo.map.Point;
import com.example.demo.map.WayFinder;
import com.example.demo.resource.GoldResource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static com.example.demo.game.GameState.ACTIVE;
import static com.example.demo.game.GameState.WAIT;

@Component
public class User {

    private GoldResource resource;
    private Point currentPoint;
    private MoveEvent event;
    private Ticker ticker;
    private Army army;





    public Army getArmy() {
        return army;
    }

    public GoldResource getResource() {
        return resource;
    }

    public User() {

        this.resource = new GoldResource();
        this.currentPoint= new Point(0,0);
        this.ticker= new Ticker();
        this.army= new Army();
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    public GameState doGame(MyMap map) {


        Point startPoint = map.getStartPoint();
        Point finishPoint = map.getFinnishPoint();
        List<Point> path = WayFinder.foundWay(map, startPoint, finishPoint);
       if( !doStep(path)) return WAIT;
        return ACTIVE;

    }
    public boolean doStep(List<Point> path){

        for (Point point: path
             ) {
          this.currentPoint=point;
          if(!ticker.checkCanDoStep())
          {
              //TODO: information for user
              //TODO button "Next Day" available
              return false;

          }

        }
       return true;
    }

}

package com.example.demo.map;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public  class WayFinder {
    private ThreeNode threeNode;
    public static List<Point> foundWay(MyMap map, Point start,Point finish )
    {
        ThreeNode threeNode= new ThreeNode(null,new HashSet<>());



        threeNode.createTreeNode(start,finish,map.getMapMatrix());


        List<Point> path=threeNode.getPath(finish,threeNode);
        return path;
    }
}

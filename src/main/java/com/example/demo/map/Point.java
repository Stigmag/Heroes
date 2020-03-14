package com.example.demo.map;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.Objects;
@Component()

@RequiredArgsConstructor
public class Point {
  private  int  x;

  private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point plusX() {
        this.x++;
        return this;
    }

    public Point minusX() {
        this.x--;
        return this;
    }

  public Point plusY() {
        this.y++;
        return this;
    }

   public Point minusY() {
        this.y--;
        return this;
    }
}
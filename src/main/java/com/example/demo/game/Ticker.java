package com.example.demo.game;

public class Ticker {
    private int limitOfStepPerDay = 10;
    private int currentNumberOfStep;

    private int count() {
        return this.currentNumberOfStep++;
    }

    public boolean checkCanDoStep() {
        return count() == limitOfStepPerDay;
    }
}

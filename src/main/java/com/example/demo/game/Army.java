package com.example.demo.game;

public class Army {
    private final Creators creators = new Creators();
    private int countOfCreators;
    private User user;

    public Army() {
        this.countOfCreators = 0;
    }

    public void hiringArmy(int countOfCreators) {
        if (user.getResource().soldSomeResource(creators.getCostOfCreators()) > 0) ;
        {
            this.countOfCreators += countOfCreators;
        }


    }

}

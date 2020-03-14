package com.example.demo.resource;

import static com.example.demo.resource.TypeOfResource.GOLD;

public abstract class UserResource {
    int value;
 final TypeOfResource typeOfResource;
    UserResource()
    {
        this.value=0;
        this.typeOfResource=GOLD;
    }

    public int countResource() {
        return this.value;
    }
    public int addResource(int capacity){
        return this.value+=capacity;
    }
    public int soldSomeResource(int capacity){
        return this.value-=capacity;
    }
}

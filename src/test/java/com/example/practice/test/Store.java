package com.example.practice.test;

public abstract class Store {
    private String name;

    abstract int sell();
    abstract int buy();

    public String getName() {
        return this.name;
    }
}

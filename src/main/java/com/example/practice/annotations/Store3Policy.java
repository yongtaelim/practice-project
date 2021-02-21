package com.example.practice.annotations;

public class Store3Policy implements Policy {
    @Override
    public void apply() {
        System.out.println("store3");
    }
}

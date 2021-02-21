package com.example.practice.annotations;

public class Store2Policy implements Policy {
    @Override
    public void apply() {
        System.out.println("store2");
    }
}

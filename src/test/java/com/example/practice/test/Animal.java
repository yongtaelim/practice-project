package com.example.practice.test;

public class Animal {
    private String name;
    private Integer step;

    public Animal(String name) {
        this.name = name;
    }

    public void walking() {
        step++;
    }
}

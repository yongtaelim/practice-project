package com.example.practice.test;

public class Dog extends Animal {
    public Dog() {
        super("navy");
    }

    @Override
    public void walking() {
        System.out.println("걷는 시늉만 한다.");
    }
}

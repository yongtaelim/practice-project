package com.example.practice.annotations;

import org.springframework.stereotype.Component;

@Component
public class SuperCar extends Car {
    @Override
    public void print() {
        System.out.println("SuperCar");
    }
}

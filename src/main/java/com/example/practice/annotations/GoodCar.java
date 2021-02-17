package com.example.practice.annotations;

import org.springframework.stereotype.Component;

@Component
public class GoodCar extends Car{
    @Override
    public void print() {
        System.out.println("GoodCar");
    }
}

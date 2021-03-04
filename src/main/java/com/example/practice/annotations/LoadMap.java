package com.example.practice.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LoadMap {

    @Qualifier("goodCar")
    private Car car;        // Car DI

    @Autowired
//    @Qualifier("car1")
    private Car superCar;    // SuperCar DI

    @Autowired
    private Car goodCar;

//    public void carPrint() {
//        car.print();
//    }

    public void superCarPrint() {
        superCar.print();    // SuperCar print
    }

    public void goodCarPrint() {
        goodCar.print();    // goodCar print
    }

    @PostConstruct
    public void setUp() {
        System.out.println("Qualifier");
//        carPrint();
        superCarPrint();
        goodCarPrint();
    }

}

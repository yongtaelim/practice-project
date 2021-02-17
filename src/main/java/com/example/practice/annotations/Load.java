package com.example.practice.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Component
public class Load {
    @Autowired
    private SuperCar goodCar;   // superCar class DI

    @Inject
    private GoodCar superCar;   // GoodCar class DI

    public void superCarPrint() {
        goodCar.print();    // superCar print
    }

    public void GoodCarPrint() {
        superCar.print();   // goodCar print
    }

    @PostConstruct
    public void setUp() {
        superCarPrint();
        GoodCarPrint();
    }

}

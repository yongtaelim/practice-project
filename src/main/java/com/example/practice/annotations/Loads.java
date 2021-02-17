package com.example.practice.annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class Loads {

    @Resource
    private Car superCar;   // SuperCar Class DI

    @Resource
    private Car goodCar;    // GoodCar Class DI

    public void superCarPrint() {
        superCar.print();   // superCar print
    }

    public void goodCarPrint() {
        goodCar.print();    // goodCar print
    }

    @PostConstruct
    public void setUp() {
        System.out.println("Resource");
        this.superCar.print();
        this.goodCar.print();
    }


}

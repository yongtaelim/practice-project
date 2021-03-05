package com.example.practice.annotations;

import java.util.ServiceLoader;

public class MyDefault {
    public static void main(String[] args) {
        ServiceLoader<DefaultService> defaultServices = ServiceLoader.load(DefaultService.class);
        for (DefaultService defaultService : defaultServices) {
            System.out.println(defaultService.defaults());
        }
    }
}

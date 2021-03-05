package com.example.practice.annotations;

public class MyDefaultService implements DefaultService {

    @Override
    public String defaults() {
        return "my default";
    }
}

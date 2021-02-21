package com.example.practice.annotations;

public class Store {
    private StorePolicyFactory storePolicyFactory;
    private Policy policy;

    public Store() {
        storePolicyFactory = new StorePolicyFactory();
    }

    public void setPolicyInstance(int type) {
        policy = storePolicyFactory.getInstance(type);
    }

    public void print() {
        policy.apply();
    }
}

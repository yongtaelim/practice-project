package com.example.practice.annotations;

public class Store1Policy implements Policy, Policy1, Policy2 {
    @Override
    public void apply() {
//        System.out.println(POLICY_NAME);
//         logic
//
//        commonApply();
//        Policy.staticCommonApply();

        System.out.println("store1");
    }
}

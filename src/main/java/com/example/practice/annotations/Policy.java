package com.example.practice.annotations;

public interface Policy {
    String POLICY_NAME = "policyName";

    void apply();

    default void commonApply() {
        System.out.println("apply common policy");
    }

    static void staticCommonApply() {
        System.out.println("apply static common policy");
    }
}

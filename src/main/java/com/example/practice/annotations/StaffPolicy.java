package com.example.practice.annotations;

public interface StaffPolicy {
    void amountPolicy();

    default void countPolicy() {};

    default void AddressPolicy() {};
}

package com.example.practice.annotations;

public interface StorePolicy {

    void amountPolicy();

    default void countPolicy() {};

    default void AddressPolicy() {};

    static void staticPolicy() {};
}

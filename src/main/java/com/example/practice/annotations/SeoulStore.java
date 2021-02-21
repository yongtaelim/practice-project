package com.example.practice.annotations;

public class SeoulStore implements StorePolicy, StaffPolicy {
    @Override
    public void amountPolicy() {
        // 써야한다.
    }

    @Override
    public void countPolicy() {
        StorePolicy.super.countPolicy();
    }

    @Override
    public void AddressPolicy() {
        StaffPolicy.super.countPolicy();
    }

    public void staticPolicy() {
        StorePolicy.staticPolicy();
    }

    // 이하 로직 Not 필수
//    @Override
//    public void countPolicy() {
        // 안쓰고 싶은데..
//    }

//    @Override
//    public void AddressPolicy() {
        // 안쓰고 싶은데..
//    }
}

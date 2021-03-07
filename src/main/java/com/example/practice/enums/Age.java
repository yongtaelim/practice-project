package com.example.practice.enums;

public enum Age {
    ONE(1, 2) {
        @Override
        int calculateAge(int index) {
            return age * index;
        }
    }

    , TWO(2, 3) {
        @Override
        int calculateAge(int index) {
            return age * index;
        }
    };

    protected final int age;
    protected final int CALCULATE_AGE;

    Age(int age, int calculateAge) {
        this.age = age;
        this.CALCULATE_AGE = calculateAge;
    }

    public int getAge() {
        return this.age;
    }

    abstract int calculateAge(int index);    // age에 곱하기 해보자
}

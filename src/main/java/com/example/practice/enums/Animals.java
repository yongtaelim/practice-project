package com.example.practice.enums;

public class Animals {
    public static void main(String[] args) {
        print();
    }

    private static void print() {
        System.out.println(Age.ONE.calculateAge(2));

        System.out.println(Age.ONE.calculateAge(3));

        System.out.println(Age.TWO.calculateAge(2));

        System.out.println(Age.TWO.calculateAge(3));
    }
}

package com.example.practice.enums;

public class Staff {
    public static void main(String[] args) {
        if (StaffAgeConstant.ONE == StaffSequenceConstant.ONE) {
            System.out.println("실행되면 안된다.");
        }
    }
}

package com.example.practice.enums;

public class Store {
    public static void main(String[] args) {
        demoTest("1");
    }

    private static void demoTest(String param) {
        if (param.equals(StoreNumberConstant.ONE)) {
            System.out.println("print 1");
        } else if (param.equals(StoreNumberConstant.TWO)) {
            System.out.println("print 2");
        } else {
            System.out.println("print else");
        }
    }
}

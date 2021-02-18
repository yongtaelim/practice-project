package com.example.practice.pack;

import com.example.practice.other.Policy;

//import static com.example.practice.pack.StoreConstant.*;
import static com.example.practice.pack.StoreConstant.ADDRESS;
import static com.example.practice.pack.StoreConstant.NAME;
import static com.example.practice.pack.StoreConstant.VISITOR;


public class Store {
    private Staff staff;
    private Policy policy;

    public Store() {
        staff = new Staff();
        policy = new Policy();

    }

    public void print() {
        System.out.println(ADDRESS);
        System.out.println(NAME);
        System.out.println(VISITOR);
    }

}

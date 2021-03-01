package com.example.practice.multis;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        notMultiThread();
        multiThread();
    }

    private static void notMultiThread() {
        Bag bag = new Bag(100);

        for (int i = 0; i < 4000; i++) {
            bag.pushItem();
        }

        for (int i = 0; i < 4000; i++) {
             bag.pushItem();
        }

        System.out.println(bag.getItemCount());
    }

    private static void multiThread() {
        Bag bag = new Bag(100);
        Thread thread1 = new Thread(new BagThread(bag));
        Thread thread2 = new Thread(new BagThread(bag));

        thread1.start();
        thread2.start();

        System.out.println(bag.getItemCount());
    }
}

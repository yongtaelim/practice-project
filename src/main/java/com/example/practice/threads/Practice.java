package com.example.practice.threads;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
//        runThread();
//        runRunnable();
         checkThreadOrder();
    }

    private static void runThread() {
        SimpleThread simpleThread = new SimpleThread();
        ThreadPractice threadPractice = new ThreadPractice(simpleThread);
        threadPractice.start();
    }

    private static void runRunnable() {
        Thread thread = new Thread(new RunnablePractice());
        thread.start();
    }

    private static void checkThreadOrder() {
        List<OrderThread> orderThreadList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            OrderThread orderThread = new OrderThread(String.valueOf(i));
            if (i <= 10) {
                orderThread.setPriority(Thread.MIN_PRIORITY);
            } else {
                orderThread.setPriority(Thread.MAX_PRIORITY);
            }

            orderThreadList.add(orderThread);
        }

        for (OrderThread orderThread : orderThreadList) {
            orderThread.start();
        }
    }
}

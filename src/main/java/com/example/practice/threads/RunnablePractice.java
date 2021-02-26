package com.example.practice.threads;

public class RunnablePractice implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Runnable.");
    }
}

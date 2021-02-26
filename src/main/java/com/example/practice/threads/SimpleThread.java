package com.example.practice.threads;

public class SimpleThread extends Thread {

    @Override
    public void run() {
        System.out.println("state : " + this.getState());    // 3)
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("state : " + this.getState());    // 4)
    }
}

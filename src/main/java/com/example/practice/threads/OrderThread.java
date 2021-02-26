package com.example.practice.threads;

public class OrderThread extends Thread {

    private String order;

    public OrderThread(String order) {
        this.order = order;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(order);
    }
}


package com.example.practice.multis;

public class BagThread implements Runnable {

    private final Bag bag;

    public BagThread(Bag bag) {
        this.bag = bag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4000; i++) {
            bag.pushItem();
        }
    }
}

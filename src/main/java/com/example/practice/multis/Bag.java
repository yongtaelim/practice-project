package com.example.practice.multis;

public class Bag {

    private Integer itemCount;

    public Bag (Integer itemCount) {
        this.itemCount = itemCount;
    }

    public synchronized void pullItem() {
        if (itemCount > 0) {
            itemCount--;
        }
    }

    public synchronized void pushItem() {
        itemCount++;
    }

    public int getItemCount() {
        return itemCount;
    }
}

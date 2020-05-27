package com.phuongnam.model;

public class ViewCounter {
    private int count;

    public ViewCounter() {
    }

    public ViewCounter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}

package com.example.practice.test;

public class Ground {
    private Robot robot;
    public Ground(Robot robot) {
        this.robot = robot;
    }

    public void run() {
        robot.attack();
    }
}

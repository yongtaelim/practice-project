package com.example.practice.multis;

public class DeadLockPractice {
    private static Object threadOneLockObject = new Object();
    private static Object threadTwoLockObject = new Object();

    public static void main(String[] args) {
        ThreadOne thread1 = new ThreadOne();
        ThreadTwo thread2 = new ThreadTwo();

        thread1.start();
        thread2.start();
    }

    static class ThreadOne extends Thread {

        @Override
        public void run() {
            synchronized (threadOneLockObject) {
                try {
                    System.out.println("ThreadOne synchronized start.");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("ThreadOne waiting");
                synchronized (threadTwoLockObject) {
                    System.out.println("ThreadOne synchronized start.");
                }
            }
        }
    }

    static class ThreadTwo extends Thread {

        @Override
        public void run() {
            synchronized (threadTwoLockObject) {
                try {
                    System.out.println("ThreadOne synchronized start.");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("ThreadOne waiting");
                synchronized (threadOneLockObject) {
                    System.out.println("ThreadOne synchronized start.");
                }
            }
        }
    }
}

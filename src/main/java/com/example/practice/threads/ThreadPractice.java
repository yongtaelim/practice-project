package com.example.practice.threads;

public class ThreadPractice extends Thread {

    private Thread simpleThread;

    public ThreadPractice(Thread simpleThread) {
        this.simpleThread = simpleThread;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Thread");

        while (true) {
            State state = simpleThread.getState();
            System.out.println("state :: " + state);    // 1), 5)

            if (State.NEW.equals(state)) {
                simpleThread.start();       // 2)
            }

            if (State.TERMINATED.equals(state)) {
                break;    // 6)
            }

            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

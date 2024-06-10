package org.example.questions;

public class Atomic {
    public static void main(String[] args) {
        SharedCounter shared = new SharedCounter();
        //creating a thread using a lambda expression
        new Thread(() -> {
            System.out.println("thread  is running");
            for (int i = 0; i < 5000; i++) {
                shared.increment();
            }
            System.out.println("thread is completed");
        }).start();

        new Thread(() -> {
            System.out.println("thread 2 is running");
            for (int i = 0; i < 5000; i++) {
                shared.increment();

            }
            System.out.println("thread 2 is completed");
        }).start();
    }
}

package org.example.questions;

//for race condition
public class SharedCounter {
    private int count;

    public synchronized   void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}




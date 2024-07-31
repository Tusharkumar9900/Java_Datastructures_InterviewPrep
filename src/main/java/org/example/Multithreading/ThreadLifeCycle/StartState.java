package org.example.Multithreading.ThreadLifeCycle;

public class StartState {
    public static void main(String[] args) {
        // Creating a new thread with a lambda expression that defines the task to be executed
        Thread object = new Thread(()->{
            // This is the task that will be executed when the thread starts
            // Currently, the thread is in the "NEW" state, as it hasn't been started yet
           System.out.println("Thread is created");
        });
        // Starting the thread
        // The start() method transitions the thread from the "NEW" state to the "RUNNABLE" state
        // In the "RUNNABLE" state, the thread is ready to run and may be running
        // The actual execution is controlled by the thread scheduler or thread executor
        object.start();
        // Getting and printing the current state of the thread
        // After calling start(), the thread enters the "RUNNABLE" state
        // The getState() method will typically return "RUNNABLE" at this point
        // However, due to the concurrent nature of threads, it may briefly be in other states depending on the timing
        System.out.println(object.getState());
    }
}

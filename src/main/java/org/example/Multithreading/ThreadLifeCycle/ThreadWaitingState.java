package org.example.Multithreading.ThreadLifeCycle;


// This class demonstrates the thread lifecycle, specifically the TIMED_WAITING state.
public class ThreadWaitingState {
    public static void main(String[] args) throws InterruptedException {

        // Create a Runnable object using an anonymous inner class
        // The Runnable interface is implemented to define the task that the thread will execute
        Runnable objectofRunnable = new Runnable() {
            @Override
            public void run() {
                try{

                    // The thread will go to sleep for 5000 milliseconds (5 seconds)
                    // During this time, the thread is in the TIMED_WAITING state
                    Thread.sleep(5000);
                }
                catch(InterruptedException e){
                    // Handle the InterruptedException
                    // This occurs if another thread interrupts the sleeping thread
                    Thread.currentThread().interrupt();// Restore the interrupted status
                    e.printStackTrace();
                }
                // After waking up from sleep, this message will be printed
                System.out.println("Thread using a runnable interface");
            }
        };

        // Creating a new thread object and assigning the Runnable task to it
        // The thread is named "Runnable thread"
        Thread object = new Thread(objectofRunnable,"Runnable thread");

        // Starting the thread
        // This moves the thread from the NEW state to the RUNNABLE state
        // Once started, the thread will execute the run() method defined in the Runnable
        object.start();

        // Main thread sleeps for 1000 milliseconds (1 second)
        // This sleep affects only the main thread, not the newly started thread
        // The main thread is in the TIMED_WAITING state during this time
        Thread.sleep(1000);


        // Retrieve and print the state of the new thread
        // Since the new thread is sleeping (via Thread.sleep(5000) in the run method),
        // it will be in the TIMED_WAITING state when we check it after 1 second
        System.out.println(object.getState()); // Expected output: TIMED_WAITING
    }
}

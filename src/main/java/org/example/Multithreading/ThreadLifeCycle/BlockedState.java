package org.example.Multithreading.ThreadLifeCycle;

public class BlockedState {
    public static void main(String[] args) throws InterruptedException{

        // Create two threads, each executing the DemoBlockedRunnable class
        Thread thread1 = new Thread(new DemoBlockedRunnable());
        Thread thread2 = new Thread(new DemoBlockedRunnable());

        // Start both threads
        thread1.start();
        thread2.start();

        // Introduce a short delay to allow both threads to start and reach a blocked state
        Thread.sleep(1000);

        // Print the state of thread2; this will likely be BLOCKED if thread1 is holding the lock on commonResource()
        System.out.println(thread2.getState());


        // Terminate the program
        System.exit(0);
    }
}

class DemoBlockedRunnable implements Runnable{

    public void run(){
        // Call the static synchronized method, which will attempt to acquire the class-level lock
        commonResource();
    }
    // Static synchronized method which locks on the class object
    public static synchronized void commonResource(){
        while(true){
            //infinite loop, thread holds the lock here
        }
    }
}

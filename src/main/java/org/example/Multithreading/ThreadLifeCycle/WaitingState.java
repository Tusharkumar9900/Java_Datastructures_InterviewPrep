package org.example.Multithreading.ThreadLifeCycle;

public class WaitingState {

   static  class DemoWaitingState implements Runnable{
        public void run(){
            try{
                // Simulate some work with sleep
                Thread.sleep(5000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        // Creating thread1 using a lambda expression
        Thread thread1 = new Thread(()->{
            System.out.println("Thread 1 is started");
        });
        thread1.start();


        // Creating thread2 using DemoWaitingState runnable
        Thread thread2 = new Thread(new DemoWaitingState());
        thread2.start();


            try {
                // Introducing a small sleep to ensure we can print the WAITING state of main thread
                Thread.sleep(1000);
//                // At this point, if we check the state of the main thread, it should be WAITING
                System.out.println(thread2.getState());
                thread2.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }


        // Print the state of thread1 and thread2
        System.out.println(thread1.getState());
//        System.out.println(thread2.getName() + " state after completion: " + thread2.getState());
    }

}

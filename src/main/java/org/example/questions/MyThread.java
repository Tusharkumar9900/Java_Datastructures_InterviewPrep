package org.example.questions;

public class MyThread {
    public static void main(String[] args) {

        //normal method to execute the thread by extending thread class
        Threading objthread = new Threading();
        objthread.start();


        //thread using lambda function to make code more useful and readable by extending thread class
        Thread objthread2 = new Thread(()->{
            System.out.println("thread 2 is running using lambda function");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("my thread 2 is completed now");
        });
        objthread2.start();


        //now we can do by implementing runnable interface
        Runnable objectRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 3 is running using runnable interface");
            }
        };
        Thread objectThread3 = new Thread(objectRunnable);
        objectThread3.start();


        Thread objectthread4 = new Thread(()->{
           System.out.println("thread 4 is running i will make it daemmon thread");
        });
        objectthread4.setDaemon(true);
        objectthread4.start();
    }
}

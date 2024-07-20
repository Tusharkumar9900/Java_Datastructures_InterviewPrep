package org.example.Multithreading;


/*


// first way to create a thread
//by making a class of thread which extends Thread class


//By Extending the Thread Class:
//This involves creating a new class that extends Thread and overriding its run method.


class mythread extends Thread{
    public void run(){
        System.out.println("thread1 is running ");
    }
}
public class MultiThreading {
    public static void main(String[] args) {
       mythread objectofthread = new mythread();
       objectofthread.start();
    }
}


 */

//--------------------------------------------------------------------------------------------------------------------------------


/*


//second way to create thread

public class MultiThreading {
    public static void main(String[] args) {
        Thread object = new Thread(()->{
            System.out.println("thread using java 8 ");
        });
        object.start();
    }
}


 */


//third way to create a thread
public class MultiThreading {
    public static void main(String[] args) {
        Runnable objectofRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread using a runnable interface");
            }
        };
        Thread object2 = new Thread(objectofRunnable,"Runnable thread");
        object2.start();

//----------------------------------------------------------------------------------------

        Runnable objectrun = ()->{
            System.out.println("Thread using runnable more optimized way");
        };
        Thread object3 = new Thread(objectrun,"Runnable thread more optimized");
        object3.start();

    }
}
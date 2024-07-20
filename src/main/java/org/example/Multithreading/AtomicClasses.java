package org.example.Multithreading;



/*

//shared object which is used by the both the threads which we create.
class SharedCounter{
    private int count;
    public void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
public class AtomicClasses {
    public static void main(String[] args) {
//The SharedCounter object is created and shared between two threads.
//This object is used to demonstrate how both threads interact with the same instance of the counter.
        SharedCounter sharedCounter = new SharedCounter();


        //creating thread 1
        new Thread(()->{
System.out.println("Thread 1 started here");
for(int i=0;i<50000;i++){
    sharedCounter.increment();
}
System.out.println("Thread 1 is completed");
        }).start();



        //created thread 2
        new Thread(()->{
          System.out.println("Thread 2 is created and started");
          for(int i=0;i<5000;i++){
              sharedCounter.increment();
          }
          System.out.println("Thread 2 completed here");
        }).start();

    }
}



//in this above code race condition is happening
//because both the thread trying to do  any operation on the shared object.
//inconsistency of data can happen in this code.

//A race condition occurs when multiple threads access and modify shared data concurrently.
//In this example, both threads are incrementing the count in SharedCounter simultaneously without any synchronization.
//This can lead to inconsistent and unexpected results, as the operations on the count variable are not atomic.
//The increment operation (count++) involves multiple steps (read, modify, write), and if interrupted by another thread, it can cause data inconsistency.


 */


//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


/*

import org.example.questions.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter{
    private AtomicInteger count = new AtomicInteger(0);

    public void increment(){
        count.incrementAndGet(); // this will make sure that new thread get the real value not the old value
    }

    public int getCount(){
        return count.get();
    }
}
//to handle the above Race Condition we use Atomic classes
public class AtomicClasses {
    public static void main(String[] args) {
        SharedCounter sharedcount = new SharedCounter();

        //create thread1
        new Thread(()->{
           System.out.println("Thread 1 start running");
           for(int i=0;i<50000;i++){
               sharedcount.increment();
           }
        }).start();

        //creating thread2
        new Thread(()->{
           System.out.println("Thread 2 is running");
           for(int i=0;i<50000;i++){
               sharedcount.increment();
           }
        }).start();
    }
}


 */


//--------------------------------------------------------------------------------------------------------------------------------------------

//Another Way to handle by using the synchronized Block

class SharedCount{
    private int count;
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
public class AtomicClasses {
    public static void main(String[] args) {
        SharedCount sharedcount = new SharedCount();
        //creating new thread
        Thread thread1 = new Thread(()->{
            System.out.println("Thread 1 started running");
            for(int i=0;i<50000;i++){
                sharedcount.increment();
            }
            System.out.println("thread 1 completed");
        });

        //creating new thread 2
        Thread thread2 = new Thread(()->{
            System.out.println("Thread 2 started running");
            for(int i=0;i<50000;i++){
                sharedcount.increment();
            }
            System.out.println("thread 2 completed");
        });

        //starting both thread
        thread1.start();
        thread2.start();
        // Ensuring the main thread waits for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //print the final count after the threads have completed
       System.out.println("Final Count" + " "+ sharedcount.getCount());
    }
}

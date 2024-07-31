package org.example.Multithreading.ThreadLifeCycle;

//step 1 of thread life cycle is when thread going to NewState
//or we can say thread is created
public class NewState {
    public static void main(String[] args) {
        // Step 1: Creating a new thread (New state)
        // When a Thread object is created, but start() has not yet been called, it is in the 'New' state.
        Thread object = new Thread(()-> {
            // Runnable's run method contains the code that constitutes the new thread's task
            System.out.println("thread is created ");
        });
        //getState()- Returns the State of Thread
        // At this point, the thread is in the 'New' state because it hasn't started yet
        System.out.println(object.getState());
    }
}

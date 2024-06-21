package org.example.Queue;
/*
Implementation of Queue Using Array
 */
public class QueueUsingArray {


        static int arr[];
        static int size;
        static int rear = -1;

        QueueUsingArray(int n) {
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("full queue");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[0];
        }

    public static void main(String[] args) {
   QueueUsingArray queue = new QueueUsingArray(100);
   queue.add(1);
   queue.add(2);
   queue.add(3);
   queue.add(4);

   while(!queue.isEmpty()){
       System.out.println(queue.peek());
       queue.dequeue();
   }
    }
}

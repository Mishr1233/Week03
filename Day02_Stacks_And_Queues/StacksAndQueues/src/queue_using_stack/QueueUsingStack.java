package queue_using_stack;

import java.util.*;
public class QueueUsingStack {

    public static void main(String[] args) {
        Queue queue =new Queue();

        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
   //display result
        queue.display();

        System.out.println("Delete element 30 :");
        queue.dequeue(30);

        System.out.println("Display result :");
        queue.display();


    }
}


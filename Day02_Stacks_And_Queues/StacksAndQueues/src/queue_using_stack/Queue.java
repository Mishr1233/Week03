package queue_using_stack;

import java.util.*;
public class Queue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> st1 = new Stack<>();

    //Add element in queue
    public void enqueue(int data) {
        st.push(data);
    }


    //delete element from queue
    public void dequeue(int data) {

        while (!st.isEmpty() && st.peek()!=data) {
            st1.push(st.pop());
        }

        if (st.isEmpty()) {
            System.out.println("element not found !");
        } else {
            st.pop();
            while (!st1.isEmpty()) {
                st.push(st1.pop());
            }
        }
    }

    //display elements of queue
    public void display() {
        System.out.println("\n");
        while (!st.isEmpty()) {
            System.out.println(st1.push(st.pop()));
        }

        while (!st1.isEmpty()) {
            st.push(st1.pop());
        }

    }
}

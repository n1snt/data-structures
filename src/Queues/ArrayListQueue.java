package Queues;

import java.util.ArrayList;
import java.util.List;

public class ArrayListQueue {

    static class Queue {
        List<Integer> data;

        Queue() {
            data = new ArrayList<>();
        }
    }

    // Main operations
    static void enQueue(Queue queue, Integer data) {
        queue.data.add(0, data);
    }

    static int deQueue(Queue queue) {
        return queue.data.remove(0);
    }

    // Aux operations.
    static void print(Queue queue) {
        int queueSize = queue.data.size();
        int i = 0;
        while (i < queueSize) {
            System.out.println(queue.data.get(i));
            i++;
        }
    }

    static int front(Queue queue) { return queue.data.get(queue.data.size()-1); }

    static int rear(Queue queue) { return queue.data.get(0); }

    static int size(Queue queue) { return queue.data.size(); }

    static boolean isEmpty(Queue queue) { return queue.data.isEmpty(); }

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Checks if queue is empty
        System.out.println("Is queue empty?: ");
        System.out.println(isEmpty(queue));

        // Insert data into queue
        enQueue(queue, 5);
        enQueue(queue, 10);
        enQueue(queue, 15);

        // Print queue
        System.out.println("Queue before: ");
        print(queue);

        // Removes last inserted element
        System.out.println("Removed element: ");
        System.out.println(deQueue(queue));

        // Print queue
        System.out.println("Queue after: ");
        print(queue);

        // Returns first inserted element
        System.out.println("First inserted element: ");
        System.out.println(front(queue));

        // Returns last inserted element
        System.out.println("Last inserted element: ");
        System.out.println(rear(queue));

        // Returns number of elements in queue
        System.out.println("Element count in queue: ");
        System.out.println(size(queue));

        // Checks if queue is empty
        System.out.println("Is queue empty?: ");
        System.out.println(isEmpty(queue));
    }
}

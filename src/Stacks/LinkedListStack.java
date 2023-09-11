package Stacks;


/**
 * This class represents a single node of a LinkedList
 */
class Node {
    int data;
    Node next;

    Node(int i) {
        data = i;
    }
}

public class LinkedListStack {

    static class Stack {
        public static final int MAX = 1000;
        int size;
        int maxSize = MAX;
        Node base;
    }

    static boolean isEmpty(Stack stack) {
        return stack.size == 0 && stack.base == null;
    }

    static boolean isFull(Stack stack) {
        return stack.size >= stack.maxSize;
    }

    static void push(Stack stack, int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (stack.size >= stack.maxSize) {
            System.out.println("Stack overflow!");
            return;
        } else {
            if (stack.base == null) {
                stack.base = newNode;
            } else {
                Node currNode = stack.base;
                while (currNode.next != null) {
                    currNode = currNode.next;
                }
                currNode.next = newNode;
            }
            stack.size++;
        }
    }

    static int pop(Stack stack) {
        // Iterate to last element.
        if (stack.size <= 0) {
            System.out.println("Stack Underflow!");
            return 0;
        } else {
            Node currNode = stack.base;
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            int lastData = currNode.next.data;
            currNode.next = null;
            stack.size--;
            return lastData;
        }
    }

    static int peek(Stack stack) {
        Node currNode = stack.base;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        return currNode.data;
    }

    static void print(Stack stack) {
        Node currNode = stack.base;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {

        // Initialize last element of stack
        Stack stack = new Stack();

        // Add data to stack
        push(stack, 1);
        push(stack, 2);
        push(stack, 3);

        // Print data from stack
        print(stack);

        // Remove last inserted element from stack
        System.out.println("\nLast removed element is: ");
        System.out.println(pop(stack));

        // Print data from stack
        System.out.println("\nNew list: ");
        print(stack);

        // Get last element of stack
        System.out.println("\nLast element of stack is: ");
        System.out.println(peek(stack));

        // Check if stack is empty
        System.out.println("\nIs stack empty? : ");
        System.out.println(isEmpty(stack));

        // Check if stack is full
        System.out.println("\nIs stack full? : ");
        System.out.println(isFull(stack));
    }
}

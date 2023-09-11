package Stacks;

public class ArrayStack {

    static class Stack {
        public static final int MAX = 1000;
        int top;
        int[] a = new int[MAX];
    }

    static void push(Stack stack, int data) {

        if (stack.top >= (Stack.MAX - 1)) {
            System.out.println("STACK OVERFLOW!!");
        } else {
            stack.a[++stack.top] = data;
        }
    }

    static boolean isEmpty(Stack stack) {
        return stack.top <= -1;
    }

    static boolean isFull(Stack stack) {
        return stack.top >= Stack.MAX - 1;
    }

    static void print(Stack stack) {
        for (int i = stack.top; i > -1; i--) {
            System.out.println(stack.a[i]);
        }
    }

    static int size(Stack stack) {
        return stack.top + 1;
    }

    static int pop(Stack stack) {
        // Remove the top most element.
        if (stack.top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        stack.top = stack.top--;
        return stack.a[stack.top--];
    }

    static int top(Stack stack) {
        return stack.a[stack.top];
    }

    public static void main(String[] args) {

        // Create new stack
        Stack stack = new Stack();
        // Set top of stack
        stack.top = -1;

        // Push to stack
        // Insert data into stack
        push(stack, 1);
        push(stack, 2);
        push(stack, 3);

        // Check if stack empty
        System.out.println("Empty?");
        System.out.println(isEmpty(stack));

        // Check if stack full
        System.out.println("Full?");
        System.out.println(isFull(stack));

        // Print stack
        print(stack);

        // Print length of stack.
        System.out.println("\nSize of Stack is :");
        System.out.println(size(stack));

        // Pop from stack
        // Removes & returns last inserted element into the stack
        System.out.println("\nRemoved element is :");
        System.out.println(pop(stack));

        // Print stack after removing element
        System.out.println("\nNew list after element removed :");
        print(stack);

        // Top returns the last element from stack without removing it.
        System.out.println("\nTop most element of stack is :");
        System.out.println(top(stack));
    }
}

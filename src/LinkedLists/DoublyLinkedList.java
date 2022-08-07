package LinkedLists;

public class DoublyLinkedList {

    Node head;

    static class Node {
        int Data;
        Node next;
        Node prev;

        Node (int i) {
            Data = i;
        }
    }

    DoublyLinkedList insert(DoublyLinkedList list, int data) {

        // Create new node with given data
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            // List is empty condition
            newNode.prev = null;
            list.head = newNode;
        } else {
            // Iterate till last node set the last as prev
            // in newNode and insert.
            Node lastNode = list.head;
            while(lastNode.next != null) {
               lastNode = lastNode.next;
            }
            newNode.prev = lastNode;
            lastNode.next = newNode;
        }

        return list;
    }

    void print(DoublyLinkedList list) {
        Node curNode = list.head;
        while (curNode != null) {
            System.out.println(curNode.Data);
            curNode = curNode.next;
        }
    }

    public static void main(String[] args) {

        // Create a linked list here
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert data into linked list
        list.insert(list,20);
        list.insert(list, 21);
        list.insert(list, 30);

        // Print linked list
        list.print(list);
    }

}

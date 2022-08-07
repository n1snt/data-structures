package LinkedLists;

public class LinkedList {

    // Head of linked list.
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int i) {
            data = i;
        }
    }

    void print(LinkedList list) {
        // This method prints the linked list.

        Node currentNode = list.head;
        System.out.println("Linked List:");

        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }

    }

    LinkedList insert(LinkedList list, int data) {
        // This method inserts node into linked list.

        // Create new node with given data.
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            // If head is empty that means linked list is empty.
            // Make the data as head.
            list.head = newNode;
        } else {
            // Traverse till last node & insert our newNode.
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        return list;
    }

    LinkedList deleteByKey(LinkedList list, int key) {
        // This method deletes node from linked list using key.

        // Store head node.
        Node currentNode = list.head, prev = null;

        // CASE 1:
        // If head node itself contains the key to be deleted.
        if (currentNode != null && currentNode.data == key) {
            // Replace the head node with the next node in list.
            list.head = currentNode.next;
            System.out.println(key + " found & deleted");
            return list;
        }

        // CASE 2:
        // If key is in a node other than head node.
        while (currentNode != null && currentNode.data != key) {
            // If current node does not contain the key
            // Continue to next node.
            prev = currentNode;
            currentNode = currentNode.next;
        }
        // If the key was present it should be at current node.
        // Therefore, current node will not be null.
        if (currentNode != null) {
            prev.next = currentNode.next;
            System.out.println(key + " found & deleted");
        }

        // CASE 3:
        // Key is not present in list.
        if (currentNode == null) {
            System.out.println(key + " not found");
        }

        return list;
    }

    LinkedList deleteByPosition(LinkedList list, int index) {
        // This method deletes the node at a specific index in linked list.

        Node currentNode = list.head, prev = null;

        // CASE 1:
        // If index == 0, then head node needs to be deleted.
        if (index == 0 && currentNode != null) {
            list.head = currentNode.next;
            System.out.println("Element deleted at position: " + index);
            return list;
        }

        // CASE 2:
        // If index > 0 & less than size of linkedList.
        int counter = 0;
        while (currentNode != null) {
            if (counter == index) {
                prev.next = currentNode.next;
                System.out.println("Element deleted at index: " + index);
                break;

            } else {
                prev = currentNode;
                currentNode = currentNode.next;
                counter++;
            }
        }

        // CASE 3:
        // If the position element was not found.
        if (currentNode == null) {
            System.out.println("Element was not found at index : " + index);
        }

        return list;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // Insert into list.
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 32);

        list.print(list);

        // Delete by key.
        list.deleteByKey(list,3);
        list.deleteByKey(list,1);
        list.insert(list, 2);

        list.print(list);

        // Delete by position.
        list.deleteByPosition(list, 1);
        list.deleteByPosition(list, 2);

        list.print(list);
    }

}

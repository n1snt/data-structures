package LinkedLists;

public class CircularLinkedList {

    Node head;

    private static class Node {

        int Data;
        Node next;

        Node(int i) { Data = i; }
    }

    CircularLinkedList insert(CircularLinkedList list, int data) {
        // If list is empty point to itself.
        // If not then insert at end & change
        // the pointer of last to new & new nodes last to head
        Node newNode = new Node(data);

        if (list.head == null) {
            newNode.next = newNode;
            list.head = newNode;
        } else {

            Node headNode = list.head;
            Node currNode = list.head;
            // Iterate over list & goto last element of list.
            do {
               currNode = currNode.next;
            } while(currNode.next != headNode);

            newNode.next = headNode;
            currNode.next = newNode;
        }

        return list;
    }

    int length(CircularLinkedList list) {

        int count = 0;
        if (list.head != null) {
            Node headNode = list.head;
            Node currNode = list.head;
            do {
                count += 1;
                currNode = currNode.next;
            } while (currNode != headNode);
        }

        return count;
    }

    CircularLinkedList print(CircularLinkedList list) {
        if (list.head != null) {
            System.out.println("Elements in list: ");
            Node headNode = list.head;
            Node currNode = list.head;
            do {
                System.out.println(currNode.Data);
                currNode = currNode.next;
            } while(currNode != headNode);
        }

        return list;
    }

    CircularLinkedList deleteByIndex(CircularLinkedList list, int index) {
        // Check if list empty
        if (list.head != null) {
            // Iterate over linked list till index
            int currentPosition = 1;
            Node currentNode = list.head;

            while (currentPosition != index) {
                currentNode = currentNode.next;
                currentPosition+=1;
            }
            currentNode.next = currentNode.next.next;
        }
        return list;
    }

    CircularLinkedList deleteByElement(CircularLinkedList list, int element) {
        // Check if list empty
        if (list.head != null) {
            // Iterate over list & search for element
            Node currentNode = list.head;
            while (currentNode.Data != element) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        return list;
    }

    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();

        list.insert(list, 20);
        list.insert(list, 21);
        list.insert(list, 22);
        list.insert(list, 23);

        // Length of list.
        System.out.println("Length of list: ");
        System.out.println(list.length(list));

        // Delete by index
        list.print(list);
        list.deleteByIndex(list, 1);
        list.deleteByIndex(list, 2);
        list.print(list);

        // Delete by key
        list.deleteByElement(list, 20);
        list.print(list);
    }
}

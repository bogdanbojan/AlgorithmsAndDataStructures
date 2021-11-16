package datastructures.linkedlist;

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    public Node head = null;
    public Node tail = null;

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }

        else // [1,2] add[3] / h1 -> t2 -> 3   tail.next is just access to the nodes properties.
        {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
    }

    public void deleteFirst() {
        Node temp = head;
        head = head.next;
    }


    public void printList() {
        Node node = head;
        while (node != null)
        {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }



}

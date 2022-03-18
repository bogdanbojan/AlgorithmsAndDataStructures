package datastructures.linkedlist;

public class DLinkedList <Item> {
    Node first;
    Node last;
    int N;

    private class Node
    {
        Item item;
        Node next;
        Node prev;
    }


    private boolean isEmpty() { return N == 0; } // or first == null.
    private int size() { return N; }

    // Queue interface
    private void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) { first = last; } // why this
        else           {oldlast.next = last;  last.prev = oldlast;}
        N++;
    }


    private Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        first.prev = null;
        if (isEmpty()) { last = null; }
        N--;
        return item;
    }


    //Stack interface. Done from the first element.
    private void push(Item item)
    {

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) { first = last; }
        else           { first.next = oldfirst; oldfirst.prev = first; }
        N++;
    }

    private Item pop()
    {
        Item item = first.item;
        first = first.next;
        first.prev = null;
        if (isEmpty()) { last = null; }
        N--;
        return item;
    }


}

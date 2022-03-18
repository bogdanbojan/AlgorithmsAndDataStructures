package datastructures.linkedlist;


import java.util.Iterator;
import java.util.LinkedList;


class SLinkedList <Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node // operations can be done in an easier fashion if you have a Node(Item item) constructor.
    {
        Item item;
        Node next;

    }



    public boolean isEmpty() { return first == null; } // or N == 0.
    public int size () { return N;}


    // Queue interface.
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }
    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) { last = null; } // why?
        N--;
        return item;

    }


    // Stack interface.
    public void push(Item item)
    {

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) { first = last; }
        else             first.next = oldfirst;
        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) { last = null; }
        N--;
        return item;
    }

    public Iterator<Item> iterator()
    { return new ListIterator(); }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        {
            return current != null;
        }
        public void remove() {}
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }



    // Stack interface. Operations at the "end" of the list.
//    public void push(Item item) // same as enqueue or can be implemented to do the operations at the beginning of the list.
//    {
//
//        Node oldlast = last;
//        last = new Node();
//        last.item = item;
//        last.next = null;
//        if (isEmpty()) { first = last;} // you would have first.next == last && last.next == null bcause it's the first item && the last item.
//        else       oldlast.next = last;
//        N++;
//    }
//
//
//    public Item pop()
//    {
//
//        // [1 -> 2 -> 3 -> 4]
//        // 1 -> 2 -> 3 -> null;
//        Item item = last.item;
//        Node temp = first;
//        while (temp.next != last) { temp = temp.next; }
//        last = temp;
//        last.next = null;
//        N--;
//        return item;
//    }


}
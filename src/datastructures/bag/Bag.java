package datastructures.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag <Item> implements Iterable<Item> {
    Node<Item> first;
    int N;

    private static class Node<Item>
    {
        Item item;
        Node<Item> next;
    }

    public boolean isEmpty() { return N==0; }
    public int size() { return N; }

    public void add(Item item)
    {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Iterator<Item> iterator()
    {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first)
        {
            this.current = first;
        }

        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); } // we are not obliged to implement this
        public Item next()
        {
            if (!hasNext()) { throw new NoSuchElementException();}
            Item item = current.item;
            current = current.next;
            return item;
        }

    }


    public static void main (String[] args)
    {
        Bag<String> bag = new Bag<String>();
        bag.add("One");
        bag.add("Two");
        bag.add("Three");

        for (String s : bag)
        {
            System.out.println(s);
        }

    }



}

package datastructures.stack;

import java.util.Arrays;
import java.util.Iterator;

public class Stack <Item>  {
    private Item[] a;
    private int N;

    public Stack(int cap)
    {
        a = (Item[]) new Object[cap];

    }

    public boolean isEmpty() { return N == 0;}
    public int size() { return N;}

    public void push(Item item)
    {
        if (N == a.length) { resize(2*a.length); }
        a[N++] = item;} // assigns a[0] and only after that it increments
    public Item pop()
    {
        Item item = a[--N];

        a[N] = null; // avoid loitering
        if (N > 0 && N == a.length/4) {resize(a.length/2);} // manage nulls
        return item;}

    public void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
        {
            temp[i] = a[i];
        }
        a = temp;
    }

//    public Iterator<Item> iterator()
//    {
//        return new ReverseArrayIterator();
//    }
//
//    private class ReverseArrayIterator implements Iterator<Item>
//    {
//        private int i=N;
//        public boolean hasNext() { return i > 0;}
//        public Item next()       { return a[--i]; }
//        public void remove()     {}
//     }


    public static void main (String[] args)
    {
        Stack<String> s = new Stack<String>(5);
        s.push("to");
        s.push("be");
        s.push("not");
        s.push("..I forgot what comes after that..");

        System.out.println(s.pop());
        System.out.println(s.pop());

//        for (String elem: s)
//        {
//            System.out.println(elem);
//        }

    }


}

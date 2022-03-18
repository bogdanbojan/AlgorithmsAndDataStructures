package datastructures.queue;


public class Queue <Item> {
    private Item[] q;
    private int N;
    private int first;
    private int last;

    public Queue(int cap) // you can have a clean constructor and have a var like INIT_CAP where you store a default capacity.
    {
        q = (Item[]) new Object[cap];
        N     = 0;
        first = 0;
        last  = 0;
    }


    public boolean isEmpty()
    {
        return N == 0; // or return size() == 0;
    }

    public int size()
    {
        return N;
    }

    public void enqueue(Item item)
    {
        if (N == q.length) {resize(2*q.length);}
        q[last++] = item;
        if (last == q.length ) last = 0;
        N++;
    }

    public void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
        {
            // + i  is basically to figure out what is the i'th element starting from first
            // % q.length is basically to not overflow the index over q's length.
            temp[i] = q[(first + i) % q.length]; // this is smart. If you had first for bigger index (say 2) you would get the next one.
        }
        q = temp;
        first = 0;
        last  = N;
    }

    public Item dequeue()
    {
        Item item = q[first];
        q[first] = null;
        N--;
        first++;
        if (first == q.length) first = 0;
        if (N > 0 && N == q.length/4) resize(q.length/2);
        return item;
    }




}


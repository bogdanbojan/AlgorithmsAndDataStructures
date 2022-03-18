package algorithms.sorting.insertion;
import static algorithms.sorting.Template.*;

public class Insertion {
    public static <T extends Comparable<T>> void sort(T[] a)
    {
        int N = a.length;
        for (int i=1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j-1);
        }
    }
}


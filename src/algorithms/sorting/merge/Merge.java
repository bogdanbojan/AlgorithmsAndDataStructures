package algorithms.sorting.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithms.sorting.Template.less;

public class Merge{

    public static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi)
    {
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++)
        {
            if      (i > mid)             a[k] = aux[j++];
            else if (j > hi)              a[k] = aux[i++];
            else if (less(aux[j], a[i]))  a[k] = aux[j++];
            else                          a[k] = aux[i++];

        }

    }

    public static <T extends Comparable<T>> void sort(T[] a)
    {
        T[] aux = Arrays.copyOfRange(a, 0, a.length);
        sort(a, aux, 0, a.length-1);
    }
    public static <T extends Comparable<T>> void sort(T[] a, T[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

}


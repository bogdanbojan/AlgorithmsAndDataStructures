package algorithms.sorting;

import algorithms.sorting.insertion.Insertion;
import algorithms.sorting.merge.Merge;
import algorithms.sorting.selection.*;


public class Template {

    public static  <T extends Comparable<T>> boolean less (T v, T w)
    { return v.compareTo(w) < 0;}

    public static  <T extends Comparable<T>> void exch (T[] a, int i, int j)
    { T t = a[i]; a[i] = a[j]; a[j] = t; }

    private static <T extends Comparable<T>> void show(T[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static <T extends Comparable<T>> boolean isSorted(T[] a)
    { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }
    public static void main(String[] args)
    { // Read strings from standard input, sort them, and print.
        String[] a = {"b", "a", "x", "y", "e"};
//        Integer[] a = {4,2,5,1};
//        Selection.sort(a);
        Merge.sort(a);
        assert isSorted(a);
        show(a);




    }



}

package algorithms.quicksort;

import java.util.Arrays;

public class QuickSort {
    /*
    INPUT
    array A of distinct integers.
    OUTPUT
    elements of A are sorted from smallest to largest.

    HIGH LEVEL DEFINITION
    - if n <= 1 return.
    - choose a pivot element p.
    - partition A around p.
    - recurse on first part of A.
    - recurse on second part of A.








     */


    public static int partitionPivot(int[] arr,int l,int r){
        int p = arr[l]; // naive implementation
        int i = l+1;
        for(int j=l+1; j <= r; j++) {
            if (arr[j] <= p) {
                int temp =  arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[l];
        arr[l] = arr[i-1];
        arr[i-1] = temp;

        return i-1;
    }

    public static void quickSort(int[] arr, int l, int r)
    {
        if (l < r){
           int p = partitionPivot(arr, l, r);

           quickSort(arr, l, p-1);
           quickSort(arr, p+1, r);
        }
    }
    public static void main(String[] args) {
        int[] testArr = {4,1,5,3,3,6,2};
        quickSort(testArr, 0, 6);

        System.out.println(Arrays.toString(testArr));
    }

}

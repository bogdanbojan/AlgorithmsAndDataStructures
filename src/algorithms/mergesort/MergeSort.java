package algorithms.mergesort;

import java.util.Arrays;

public class MergeSort {
    public static void  mergeSort(int[] arr) {
        if ( arr.length < 2 ) {
            return;
        }

        int mid = arr.length / 2;
        int length = arr.length;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length - mid];

        for (int i = 0; i < mid; i++) { // You can also use Arrays.copyOfRange
            leftArr[i] = arr[i];
        }

        for (int j = mid; j < length; j++) {
            rightArr[j - mid] = arr[j];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr, mid, length-mid);

    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(leftArr));
        System.out.println(Arrays.toString(rightArr));
        System.out.println("");

        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(leftArr));
        System.out.println(Arrays.toString(rightArr));
        System.out.println("-----------------------");

    }


    public static void main(String[] args) {
        int[] testArr = {3,7,5,11,1,5,2};
        mergeSort(testArr);

        System.out.println(Arrays.toString(testArr));
    }
}


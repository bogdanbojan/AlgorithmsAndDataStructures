package algorithms.countinginversions;

import java.util.Arrays;

public class CountingInversions {

    public static int countSplitInversions(int[] arr, int[] aux, int low, int mid, int high) {
        int k = low, i = low, j = mid + 1;
        int inversionCount = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
                inversionCount += (mid - i + 1); // NOTE
            }
        }

        while (i <= mid) {
            aux[k++] = arr[i++];
        }

        while (j <= high) { // no need for this step since the reamining items are already in their correct position in the temp array
            aux[k++] = arr[j++];
        }

        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }

        return inversionCount;
    }


    public static int countInversions(int[] arr, int[] aux, int low, int high) {
        int inversionCount = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            inversionCount += countInversions(arr, aux, low, mid);
            inversionCount += countInversions(arr, aux, mid + 1, high);
            inversionCount += countSplitInversions(arr, aux, low, mid, high);
        }
        return inversionCount;
    }
        public static void main(String[] args) {
        int[] arr = { 1, 9, 6, 4, 5 };
        int[] aux = Arrays.copyOf(arr, arr.length);
        System.out.println("The inversion count is: " + countInversions(arr, aux, 0, arr.length - 1));

        System.out.println(Arrays.toString(arr));
    }
}

// https://www.baeldung.com/cs/counting-inversions-array
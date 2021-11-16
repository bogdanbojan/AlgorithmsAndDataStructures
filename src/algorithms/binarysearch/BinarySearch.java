package algorithms.binarysearch;
// this can be done iteratively (O(1))  or recursively (O(logn)) SPACE COMPLEXITY
// think about m-1 and m+1


public class BinarySearch {

    static int recursiveBinarySearch(int[] arr, int low, int high, int k) {

        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return mid;
            }
            if (arr[mid] < k) {
                return recursiveBinarySearch(arr, mid + 1, high, k);
            } else {
                return recursiveBinarySearch(arr, low, mid - 1, k);
            }
        }
        return -1;

    }
    static int iterativeBinarySearch(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = low + (high - low)/2; // to not overflow to a neg value

            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;

    }
    public static void main (String[] args) {
        int[] arr = {1,3,4,6,7};
        System.out.println( iterativeBinarySearch(arr, 4));
        System.out.println( recursiveBinarySearch(arr, 0, arr.length-1, 6));
    }
}

package algorithms.rselect;
// compute the ith order statistic
// also called QuickSelect
// TODO: implement this with a random pivot


// why i-1 and why return i in partition step, not i-1
public class RSelect {
    public static int partition(int[] arr, int low, int high) {
        int i = low + 1;
        int pivot = arr[low];

        for (int j=low+1; j <= high; j++ ) {
            if (arr[j] <= pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        int temp = arr[low];
        arr[low] = arr[i-1];
        arr[i-1] = temp;

        return i-1;
    }

    public static int rSelect(int[] arr, int low, int high, int i) {

        if (low < high) {
            int j = partition(arr, low, high);
            if (j == i - 1) {
                return arr[j];
            } else if (j > i - 1) {
                return rSelect(arr, low, j - 1, i); // you don't want to get to the other one. you want to isolate this
            } else {
                return rSelect(arr, j + 1, high, i);
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15 };
        System.out.println("The ith order statistic is " + rSelect(arr, 0, arr.length-1, 1)); // or you can give it as an input i-1 => so you leave it in the loops i
    }

}

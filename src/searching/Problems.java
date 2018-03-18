package searching;

public class Problems {

    public static boolean linearSearch(int[] arr, int item, int n) {

        for (int i = 0; i < n; i++) {
            if (arr[i] == item) return true;
        }

        return false;
    }

    public static boolean binSearch(int[] arr, int k, int n) {
        return binSearch(arr, k, 0, n - 1);
    }

    public static boolean binSearchIterative(int[] arr, int k, int n) {
        int low = 0;
        int high = n - 1;

        while (low <=high) {
            int mid = (low + high) / 2;
            if (arr[mid] > k) high = mid - 1;
            else if (arr[mid] < k) low = mid + 1;
            else return true;
        }
        return false;
    }

    private static boolean binSearch(int[] arr, int k, int start, int end) {

        if (start > end) return false;

        int mid = (start + end) / 2;

        if (arr[mid] > k) return binSearch(arr, k, start, mid - 1);
        else if (arr[mid] < k) return binSearch(arr, k, mid + 1, end);
        else return true;
    }
}

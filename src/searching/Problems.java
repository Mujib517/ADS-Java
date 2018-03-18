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

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > k) high = mid - 1;
            else if (arr[mid] < k) low = mid + 1;
            else return true;
        }
        return false;
    }

    //O(N)
    public static int sqrt(int n) {
        int max = n / 2;
        for (int i = 0; i < max; i++) {
            if (i * i == n) return i;
        }
        return -1;
    }

    public static int sqrt2(int n) {
        int lo = 0;
        int hi = n / 2;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            int val = mid * mid;

            if (val < n) lo = mid + 1;
            else if (val > n) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    // arr: 1,2,3,4,7,10,12
    // arr[i]=i+1
    public static int findFirstMissingNumber(int[] arr, int n) {
        int lo = 0, hi = n - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (arr[mid] == mid + 1) lo = mid + 1;
            else if (arr[mid] > mid + 1) hi = mid - 1;
        }

        return mid + 1;
    }

    //arr: 5,6,7,8,10,15
    //arr[i]= i+arr[0]
    public static int findFirstMissingNumber2(int[] arr, int n) {
        int lo = 0, hi = n - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int val = mid + arr[0];
            if (arr[mid] == val) lo = mid + 1;
            else if (arr[mid] > val) hi = mid - 1;
        }

        return mid + arr[0] + 1;
    }

    private static boolean binSearch(int[] arr, int k, int start, int end) {

        if (start > end) return false;

        int mid = (start + end) / 2;

        if (arr[mid] > k) return binSearch(arr, k, start, mid - 1);
        else if (arr[mid] < k) return binSearch(arr, k, mid + 1, end);
        else return true;
    }
}

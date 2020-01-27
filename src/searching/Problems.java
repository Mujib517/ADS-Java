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

    public static int interpolatedSearch(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1, pos;
        while (low <= high) {
            pos = low + ((k - arr[low]) * (high - low) / (arr[high] - arr[low]));

            if (arr[pos] == k) return pos;
            else if (arr[pos] < k) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    //O(N)
    public static int sqrt(int n) {
        int max = n / 2;
        for (int i = 0; i < max; i++) {
            if (i * i == n) return i;
        }
        return -1;
    }

    // test case sqrt(169)
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

    //O(N)
    public static int ceil(int[] arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (arr[i] >= k) return arr[i];
        }

        return -1;
    }

    //Log(N)
    public static int ceil2(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int mid = Integer.MIN_VALUE;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == k) return arr[mid];
            if (arr[mid] > k) high = mid;
            else if (arr[mid] < k) low = mid + 1;
        }

        return arr[low] >= k ? arr[low] : -1;
    }

    public static int ceilRecursive(int[] arr, int low, int high, int k) {

        if (low > high) return -1;

        if (arr[low] >= k) return arr[low];

        int mid = low + (high - low) / 2;

        if (arr[mid] == k) return arr[mid];
        if (arr[mid] < k) return ceilRecursive(arr, mid + 1, high, k);
        return ceilRecursive(arr, low, mid - 1, k);
    }

    public static int floor(int[] arr, int low, int high, int k) {

        if (low > high) return -1;

        if (arr[high] < k) return arr[high];

        int mid = low + (high - low) / 2;
        if (arr[mid] == k) return arr[mid];

        if (mid > 0 && arr[mid - 1] <= k && k < arr[mid]) return arr[mid - 1];

        if (k < arr[mid]) return floor(arr, low, mid - 1, k);
        return floor(arr, mid + 1, high, k);

    }

    // -8 -3 -2 -1 1 2 3 4 5 6
    public static int firstPositiveNumber(int[] arr, int low, int high) {
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == 0) return arr[mid + 1];
            if (arr[mid] < 0) low = mid + 1;
            else if (arr[mid] > 0) high = mid;
        }

        return arr[low] > 0 ? arr[low] : -1;
    }

    public static int findFirstTrue(boolean[] arr, int low, int high) {
        if (arr[low]) return 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && arr[mid] && !arr[mid - 1]) return mid;
            if (arr[mid]) high = mid;
            else low = mid + 1;
        }

        return -1;
    }

    //MLog(N) after improvement M+LogN
    public static boolean binSearch(int[][] arr, int m, int n, int k) {
        for (int i = 0; i < m; i++) {

            if (arr[i][n - 1] < k) continue;

            if (search(arr, i, n, k) != -1) return true;
        }
        return false;
    }

    private static int search(int[][] arr, int idx, int m, int k) {
        System.out.println("Called..");
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[idx][mid] == k) return mid;

            if (arr[idx][mid] < k) low = mid + 1;

            else high = mid - 1;
        }
        return -1;
    }


    // arr: 0 1 2 3 3 3 3 3 3 4
    public static int firstOccurence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && arr[mid - 1] != k && arr[mid] == k) return mid;
            if (arr[mid] == k) high = mid;
            else if (arr[mid] > k) high = mid - 1;
            else low = mid + 1;
        }

        return arr[low] == k ? low : -1;
    }

    public static int lastOccurence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (mid < n - 1 && arr[mid + 1] != k && arr[mid] == k) return mid;
            if (arr[mid] == k) low = mid;
            else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }

        return arr[high] == k ? high : -1;
    }

    public static int countFrequency(int[] arr, int n, int k) {
        int start = firstOccurence(arr, n, k);
        int end = lastOccurence(arr, n, k);

        return start == -1 || end == -1 ? 0 : end - start + 1;
    }

//    public static int filePartition(int[] arr, int n, int k) {
//        int low = arr[0], high = arr[n - 1];
//
//        while (low < high) {
//            int mid = low + (high - low) / 2;
//
//            isFeasible(arr,)
//        }
//    }

//    private static boolean isFeasible(int[] arr, int k) {
//
//    }

    private static boolean binSearch(int[] arr, int k, int start, int end) {

        if (start > end) return false;

        int mid = (start + end) / 2;

        if (arr[mid] > k) return binSearch(arr, k, start, mid - 1);
        else if (arr[mid] < k) return binSearch(arr, k, mid + 1, end);
        else return true;
    }
}

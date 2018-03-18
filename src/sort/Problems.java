package sort;

        /*
         * Important problems: MergeSort, QuickSort and Count Sort
         * */

public class Problems {

    public static void bubbleSortNaive(int[] arr, int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 1; j < n; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

            printArray(arr, n);
        }
    }

    public static void bubbleSortImproved(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            int swaps = 0;

            for (int j = 1; j < n; j++) {
                if (arr[j] < arr[j - 1]) {
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

            if (swaps == 0) break;
            printArray(arr, n);
        }
    }

    public static void selectionSort(int[] arr, int n) {

        for (int i = 0; i < n - 1; i++) {

            int min = i + 1;

            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) min = j;
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            printArray(arr, n);
        }
    }

    public static void insertionSort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {

            int j = i;

            while (j > 0) {

                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else break;

                j--;
            }
            printArray(arr, n);
        }
    }

    public static void mergeSort(int[] arr, int n) {
        int[] temp = new int[n];
        mergeSort(arr, temp, 0, n - 1);
    }

    public static void quicksort(int[] arr, int n) {
        quicksort(arr, 0, n - 1);
    }

    public static void sort10s(int[] arr, int n) {
        int p1 = 0, p2 = n - 1;

        while (p1 < p2) {

            if (arr[p1] == 0) p1++;
            if (arr[p2] == 1) p2--;

            if (arr[p1] == 1 && arr[p2] == 0) {
                arr[p2--] = 1;
                arr[p1++] = 0;
            }
        }
    }

    private static void quicksort(int[] arr, int low, int high) {
        if (low == high) return;
        int pIndex = getPartitionIndex(arr, low, high);
        quicksort(arr, low, pIndex);
        quicksort(arr, pIndex + 1, high);
    }

    private static int getPartitionIndex(int[] arr, int low, int high) {
        while (low < high) {
            int pivot = (low + high) / 2;

            while (arr[low] < arr[pivot]) low++;
            while (arr[high] > arr[pivot]) high--;

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        return low;
    }

    private static void mergeSort(int[] arr, int[] temp, int low, int high) {

        if (low == high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);
        merge(arr, temp, low, high);

    }

    private static void merge(int[] arr, int[] c, int low, int high) {

        int mid = (low + high) / 2;

        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) c[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];

        while (i <= mid) c[k++] = arr[i++];

        while (j <= high) c[k++] = arr[j++];

        System.arraycopy(c, low, arr, low, high - low + 1);
    }

    private static void printArray(int[] arr, int n) {
        for (int el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}

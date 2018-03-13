package sort;

import java.util.Arrays;

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

    public static void countSort(int[] arr, int n) {
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            while (c > 0) {
                System.out.print(i + " ");
                c--;
            }
        }
    }

    public static void printArray(int[] arr, int n) {
        for (int el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}

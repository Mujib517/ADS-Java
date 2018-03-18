package searching;

public class Problems {

    public static boolean linearSearch(int[] arr, int item, int n) {

        for (int i = 0; i < n; i++) {
            if (arr[i] == item) return true;
        }

        return false;
    }
}

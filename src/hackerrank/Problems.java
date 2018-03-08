package hackerrank;

public class Problems {

    //https://www.hackerrank.com/challenges/equality-in-a-array/problem
    public static int equalizeArray(int[] arr, int n) {
        int[] count = new int[101];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        int max = 0;

        for (int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }

        return n - max;
    }
}

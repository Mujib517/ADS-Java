package hackerrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

    //https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
    //O(N*2)
    public static int minAbsDifference(int[] arr, int n) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                min = Math.min(min, Math.abs(arr[i] - arr[j]));
            }
        }

        return min;
    }

    //O(NLogN + N) ==> O(NLogN)
    public static int minAbsDifference2(Integer[] arr, int n) {
        Arrays.sort(arr, Collections.reverseOrder());

        Integer min = Integer.MAX_VALUE;
        int p1 = 0, p2 = 1;

        while (p1 < n && p2 < n) {
            min = Math.min(min, Math.abs(arr[p1] - arr[p2]));
            p1++;
            p2++;
        }
        return min;
    }

    //https://www.hackerrank.com/challenges/marcs-cakewalk/problem
    // arr[0]*2^0 + arr[1]*2^1 .... Find min miles to walk
    public static long milesToWalk(Integer[] arr, int n) {
        Arrays.sort(arr, Comparator.reverseOrder());

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i] * Math.pow(2, i);
        }

        return sum;
    }
}

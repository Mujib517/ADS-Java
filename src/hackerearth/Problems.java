package hackerearth;

public class Problems {

    //https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/bishu-and-soldiers/description/
    public static void soldiers(int[] arr, int n, int[] queries) {
        int[] prefixSum = new int[n];

        prefixSum[0] = arr[0];

        for (int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + arr[i];


        for (int v : prefixSum) System.out.print(v + " ");
        System.out.println();
        // 1, 3, 6, 10, 15
        for (int q : queries) calculate(prefixSum, n, q);
    }

    private static void calculate(int[] arr, int n, int k) {
        System.out.println(k >= n - 1 ? n + " " + arr[n - 1] : k + " " + arr[k - 1]);
    }
}

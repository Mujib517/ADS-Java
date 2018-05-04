package bitManipulation;

public class Problems {

    public static void combinations(char[] arr, int n) {
        int max = (1 << n);

        for (int i = 1; i < max; i++) {

            int j = 0;

            while (j < n) {

                if ((i & (1 << j)) > 0) System.out.print(arr[j] + " ");

                j++;
            }

            System.out.println();
        }
    }

    //Generate a binary number with x 1's and y 0's
    public static int random(int x, int y) {
        int value = (1 << x) - 1;   //if x=3 value woulbe 2^3-1
        return (value << y);
    }
}

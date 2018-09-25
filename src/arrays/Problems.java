package arrays;

public class Problems {

    public static int[][] tranposeMatrix(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < result[0].length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void printMatrixSpiralOrder(int[][] matrix) {
        boolean ltr = true;

        for (int i = 0; i < matrix.length; i++) {

            if (ltr) {
                int j = 0;

                while (j < matrix[0].length) {
                    System.out.print(matrix[i][j] + " ");
                    j++;
                }
            } else {
                int j = matrix[0].length - 1;
                while (j >= 0) {
                    System.out.print(matrix[i][j] + " ");
                    j--;
                }
            }
            System.out.println();
            ltr = !ltr;
        }
    }

    public static int[][] matrixMultiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }


        return c;
    }

    public static int nextNumberWithSameDigit(int[] arr) {

        int d1 = -1;
        int i = arr.length - 1;
        while (i > 0) {
            if (arr[i] > arr[i - 1]) {
                d1 = i - 1;
                break;
            }
            i--;
        }


        if (i == 0) throw new IllegalStateException();

        int min = d1;
        ++i;
        while (i < arr.length - 1) {
            if (arr[i] < arr[min] && arr[d1] < arr[min]) min = i;
            i++;
        }

        int temp = arr[d1];
        arr[d1] = arr[min];
        arr[min] = temp;

        String result = "";

        for (
                int j = 0;
                j < arr.length; j++)

        {
            result += Integer.toString(arr[j]);
        }

        return Integer.parseInt(result);
    }
}

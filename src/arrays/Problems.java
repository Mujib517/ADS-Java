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
}

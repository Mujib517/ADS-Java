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
}

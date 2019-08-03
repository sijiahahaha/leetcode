import java.util.Arrays;
class Solution {
    public static int[] findDiagnoalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException("invalid inpur");
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m*n];
        int x = 0;
        int y = 0;
        int k = 0;
        int[] dx = new int[]{-1, 1};
        int[] dy = new int[]{1, -1};
        for (int i = 0; i < m*n; i++) {
            result[i] = matrix[x][y];
            x += dx[k];
            y += dy[k];
            if (x >= m) {
                x = m - 1;
                y += 2;
                k = 1 - k;
            }
            if (y >= n) {
                y = n - 1;
                x += 2;
                k = 1 - k;
            }
            if (x < 0) {
                x = 0;
                k = 1 - k;
            }
            if (y < 0) {
                y = 0;
                k = 1 - k;
            }

        }
        return result;
    }
}

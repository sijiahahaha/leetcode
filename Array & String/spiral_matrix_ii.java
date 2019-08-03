import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution{
    public static int[][] generateMatrix(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int[][] matrix = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0;
        int x = 0, y = 0;
        for (int i = 1; i <= n * n; i++) {
            matrix[x][y] = i;
            x += dx[d % 4];
            y += dy[d % 4];
            if (x < 0 || x >= n || y < 0 || y >= n || matrix[x][y] != 0) {
                x -= dx[d % 4];
                y -= dy[d % 4];
                d += 1;
                x += dx[d % 4];
                y += dy[d % 4];
            }
        }
        return matrix;
    }

}

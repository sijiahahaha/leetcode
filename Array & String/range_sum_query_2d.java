To calculate sums, the ideas as below

+-----+-+-------+     +--------+-----+     +-----+---------+     +-----+--------+    +-----+-+-------+
|     | |       |     |        |     |     |     |         |     |     |        |    |               |
|     | |       |     |        |     |     |     |         |     |     |        |    |               |
+-----+-+       |     +--------+     |     |     |         |     +-----+        |    +               |
|     | |       |  =  |              |  +  |     |         |  -  |              | +  |               |
+-----+-+       |     |              |     +-----+         |     |              |    +       +       |
|               |     |              |     |               |     |              |    |               |
|               |     |              |     |               |     |              |    |               |
+---------------+     +--------------+     +---------------+     +--------------+    +---------------+

   sums[i][j]      =    sums[i-1][j]    +     sums[i][j-1]    -   sums[i-1][j-1]   +  matrix[i-1][j-1]


so, we use the same idea to find the specific area's sum.

+---------------+   +--------------+   +---------------+   +--------------+   +--------------+
|               |   |         |    |   |   |           |   |         |    |   |   |          |
|   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
|   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
|   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
|   |      |    |   |         |    |   |   |           |   |              |   |              |
|   +------+    |   +---------+    |   +---+           |   |              |   |              |
|        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
+---------------+   +--------------+   +---------------+   +--------------+   +--------------+



class Solution {
    int[][] prefixSum;
    public NumArray(int[] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length     == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i- 1][j - 1];
            }
        }
    }

    public int sumRange(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);
        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);
        return prefixSum[iMax + 1][jMax + 1] - prefixSum[iMax + 1][jMin] - prefixSum[iMin][jMax + 1] + prefixSum[iMin][jMin];
    }
}
~

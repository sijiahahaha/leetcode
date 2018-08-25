/**
只能向下或向右。有障碍。从start到end有多少种走法
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

1.state f[i][j]表示走到ij有多少种走法
    int[][] f
2.function
   无障碍：f[i][j] = f[i - 1][j] + f[i][j - 1]
   有障碍: f[i][j] = 0
3.initialize
    f[0][j] = 1
    f[i][0] = 1
    遍历到有障碍就break
4.answer
     f[m - 1][n - 1]

**/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0 || n == 0) {
            return 1;
        }
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                f[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                f[0][i] = 1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
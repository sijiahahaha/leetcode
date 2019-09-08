class Solution {
    boolean[][] visited;
    int[][] dp;
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new boolean[m][n];
        dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int x, int y) {
        if (visited[x][y]) return dp[x][y];
        dp[x][y] = 1;
        for (int i = 0; i< 4; i++) {
            int px = x + dx[i];
            int py = y + dy[i];
            if (validate(matrix, x, y, px, py)) 
                dp[x][y] = Math.max(dp[x][y], dfs(matrix, px, py) + 1);
        }
        visited[x][y] = true;
        return dp[x][y];
    }
    
    private boolean validate(int[][] matrix, int x, int y, int px, int py) {
        int m = matrix.length;
        int n = matrix[0].length;
        return px >= 0 && px < m && py >= 0 && py < n && matrix[px][py] < matrix[x][y];
    }
}
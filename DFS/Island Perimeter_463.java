/**
对于每一个land，跟水或边界相接的一边形成周长
==> 找到每一个land，看四周有几个water或边界
**/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int p = 0;
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return p;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++){
                        if (isBoundary(i + dx[k], j + dy[k], grid)) {
                            p += 1;
                        }
                    }
                }
            }
        }

        return p;
    }

    private boolean isBoundary(int x, int y, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return true;
        }
        return grid[x][y] == 0;
    }
}

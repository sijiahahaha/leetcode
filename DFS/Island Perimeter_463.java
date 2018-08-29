/**
对于每一个land，跟水或边界相接的一边形成周长 
==> 找到每一个land，看四周有几个water或边界
**/

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if (water(grid, i + dx[k], j + dy[k])) {
                            perimeter++;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
    private boolean water(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (0 <= x && x < m && 0 <= y && y < n) {
            return grid[x][y] == 0;
        }
        return true;
    }
}
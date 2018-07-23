/**  
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
 中间有3个岛

 1. dfs
    遇到1时，result++， 把1变成0，遍历dfs上下左右，把相连的1都变为0。
    再接着找下一个1。
 2. bfs
    遇到1时，result++， 把1变成0，把1的上下左右放去queue中，bfs遍历，把相连的1都变为0。
    再接着找下一个1。

**/

//DFS
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    
    private void dfs(boolean[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        
        if (grid[i][j]) {
            grid[i][j] = false;
            dfs(grid, i+1, j);
            dfs(grid, i, j+1);
            dfs(grid, i-1, j);
            dfs(grid, i, j-1);
        }
    }
}


// BFS
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    class coordinate{
        int x;
        int y;
        
        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(boolean[][] grid) {
        int m = grid.length;
        if (m <= 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n <= 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        
        return result;
    }
    
    private void bfs(boolean[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int[] xDirection = {1, 0, -1, 0};
        int[] yDirection = {0, 1, 0, -1};
        Queue<coordinate> queue = new LinkedList<coordinate>();
        queue.offer(new coordinate(i,j));
        grid[i][j] = false;
        while (!queue.isEmpty()) {
            coordinate curr = queue.poll();
            for (int k = 0; k < 4; k ++) {
                coordinate adj = new coordinate(curr.x + xDirection[k], curr.y + yDirection[k]);
                if (!(adj.x < 0 || adj.x >= m || adj.y < 0 || adj.y >= n)) {
                    if (grid[adj.x][adj.y]) {
                        queue.offer(adj);
                        grid[adj.x][adj.y] = false;
                    }
                }
            }
        }
    }
}
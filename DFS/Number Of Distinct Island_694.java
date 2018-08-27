/**  
找到不同的岛
DFS
每找到一个点，记录跟上一点的运动轨迹，最后形成一条Path
将path放入set 
返回set size， set可以自动过滤重复


BFS
1. 仍是用BFS找岛
2. 每找到一个点，将和原点（第一个1）的xy差值存入set   Set<List<List<Integer>>> set = new HashSet<>();
3. 返回set size， set可以自动过滤重复

**/
//dfs
public class Solution {
    int[] xDirections = new int[] {0, 1, 0, -1};
    int[] yDirections = new int[] {1, 0, -1, 0};
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        Set<String> set = new HashSet<>();
        
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    String path = dfs(grid, i, j);
                    set.add(path);
                }
            }
        }
        
        return set.size();
    }
    
    private String dfs(int[][] grid, int i, int j) {
        String path = "";
        
        for (int k = 0; k < 4; k++) {
            int x = i + xDirections[k];
            int y = j + yDirections[k];
            
            if (!isInbound(grid, x, y)) {
                continue;
            }
            
            if (grid[x][y] == 0) {
                continue;
            }
            
            grid[x][y] = 0;
            path += k + dfs(grid, x, y);
        }
        
        return path.length() != 0 ? path : ";";
    }
    
    private boolean isInbound(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return false;
        }
        
        if (j < 0 || j >= grid[0].length) {
            return false;
        }
        
        return true;
    }
}




//bfs
class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        if (m <= 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n <= 0) {
            return 0;
        }
        
        Set<List<List<Integer>>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<List<Integer>> ls = bfs(grid, i,j);
                    set.add(ls);
                }
            }
        }
        
        return set.size();
    }
    
    private List<List<Integer>> bfs(int[][] grid, int i, int j) {
        List<List<Integer>> ls = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[] xDirection = {1, 0, -1, 0};
        int[] yDirection = {0, 1, 0, -1};
        Queue<Integer> queueX = new LinkedList<Integer>();
        Queue<Integer> queueY = new LinkedList<Integer>();
        queueX.offer(i);
        queueY.offer(j);
        grid[i][j] = 0;
        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();
            List<Integer> curr = new ArrayList<>();
            curr.add(x - i);
            curr.add(y - j);
            ls.add(curr);
                      
            for (int k = 0; k < 4; k ++) {
                int newX = x + xDirection[k];
                int newY = y + yDirection[k];
                if (!(newX < 0 || newX >= m || newY < 0 || newY >= n)) {
                    if (grid[newX][newY] == 1) {
                        queueX.offer(newX);
                        queueY.offer(newY);
                        grid[newX][newY] = 0;
                    }
                }
            }
        }
        return ls;
    }
    
}
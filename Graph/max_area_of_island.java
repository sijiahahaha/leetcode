max_area_of_island.java 
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0] == null || grid[0].length <= 0)
			return 0;
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					res = Math.max(res, dfs(grid, i, j));
				}
			}
		}
		return res;
    }
    private int dfs(int[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;
		int res = 0;
		if (grid[x][y] == 1) {
			grid[x][y] = 0;
			res += 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
		}
		return res;
	}
}
flood_fill.java     
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
		int oldColor = image[sr][sc];
		dfs(image, sr, sc, oldColor, newColor);
		return image;
    }
    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
		int m = image.length;
		int n = image[0].length;
		if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != oldColor) return;
		image[x][y] = newColor;
		dfs(image, x + 1, y, oldColor, newColor);
		dfs(image, x - 1, y, oldColor, newColor);
		dfs(image, x, y + 1, oldColor, newColor);
		dfs(image, x, y - 1, oldColor, newColor);
	}
}

/**
按照右下左上的顺序遍历，方向是d % 4。 遇到 !inBound 或 visited时， d+1。 
**/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0;
        int[][] visited = new int[m][n];
        int x = 0, y = 0;
        for (int i = 0; i < m*n; i++) {
            result.add(matrix[x][y]);
            visited[x][y] = 1;
            x += dx[d];
            y += dy[d];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == 1) {
                x -= dx[d];
                y -= dy[d];
                d = (d + 1) % 4;
                x += dx[d];
                y += dy[d];
            }
        }
        return result;
    }
}
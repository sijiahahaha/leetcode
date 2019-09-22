class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, i, 0, visited);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfs(board, i, n - 1, visited);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(board, 0, j, visited);
            }
            if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                dfs(board, m - 1, j, visited);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int x, int y, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) return;
        if (board[x][y] != 'O') return;
        visited[x][y] = true;
        board[x][y] = 'T';
        dfs(board, x + 1, y, visited);
        dfs(board, x - 1, y, visited);
        dfs(board, x, y + 1, visited);
        dfs(board, x, y - 1, visited);
        
    }
}
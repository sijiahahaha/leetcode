/**

1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡

2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活

3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡

4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活

in-place:
状态0： 死细胞转为死细胞

状态1： 活细胞转为活细胞

状态2： 活细胞转为死细胞

状态3： 死细胞转为活细胞
**/

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = countLiveNum(board, i, j);
                if (board[i][j] == 1) {
                    board[i][j] = (num == 2 || num == 3) ? 1 : 2;
                } else {
                    board[i][j] = num == 3 ? 3 : 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }

    public int countLiveNum(int[][] board, int i, int j) {
        int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
        int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
        int count = 0;
        for (int n = 0; n < 8; n++) {
            int x = i + dx[n];
            int y = j + dy[n];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            if (board[x][y] == 1 || board[x][y] == 2) {
                count++;
            }
        }
        return count;
    }
}


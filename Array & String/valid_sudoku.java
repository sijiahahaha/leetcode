/**
swap only once to get the maximum number
 **/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            boolean[] flag = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (flag[num - 1] == true) {
                        return false;
                    }
                    flag[num - 1] = true;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            boolean[] flag = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (flag[num - 1] == true) {
                        return false;
                    }
                    flag[num - 1] = true;
                }
            }
        }

        for (int k = 0; k < 9; k++) {
            boolean[] flag = new boolean[9];
            for (int i = k / 3; i < k / 3 + 3; i++) {
                for (int j = k % 3; j < k % 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '0';
                        if (flag[num - 1] == true) {
                            return false;
                        }
                        flag[num - 1] = true;
                    }
                }
            }
        }

        return true;
    }
}


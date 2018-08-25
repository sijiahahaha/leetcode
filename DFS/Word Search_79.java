/**  
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


DFS
遍历每一个board[i][j]， 看是否可以从这位开始构成word
**/

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, visited, i, j, index)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        
        //after recursion and find word stirng
        if (index == len) {
            return true;
        }
        
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        
        
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        
        if (helper(board, word, visited, i + 1, j, index + 1) ||
            helper(board, word, visited, i - 1, j, index + 1) ||
            helper(board, word, visited, i, j + 1, index + 1) ||
            helper(board, word, visited, i, j - 1, index + 1) ) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
        
    }
}
/**
DFS 注意与number of island的区别 （最左边和最右边的有可能也有关系，并不是分开的，所以不能用island方法）。比如下面，三个单独的1其实都和右下是联通的
1 0 0 1
0 1 1 0
0 1 1 1
1 0 1 1

用visited记录这个人是否已经遍历过了
每个人都肯定会属于某个朋友圈（自己也是朋友圈）
遍历人，对于每个人，找他的朋友，再dfs朋友的朋友
**/
class Solution {
    public int findCircleNum(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        if (m <= 0 || n <= 0 || m != n) {
            return 0;
        }
        boolean[] visited = new boolean[m];
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                result++;
                dfs(M, visited, i);
            }
        }
        return result;
    }
    
    private void dfs(int[][] M, boolean[] visited, int i) {
        int m = M.length;
        visited[i] = true;
        for (int j = 0; j < m; j++) {
            if (!visited[j] && M[i][j] == 1) {
                dfs(M, visited, j);
            }
        }
        
    }
}


/**
1 0 0 1
0 1 1 0
0 1 1 1
1 0 1 1

**/
/**
DP
f[i][j]表示 i～j所需要的min cost
f[n+1][n+1] 加一位在最前面

可以发现对于区间 [i, j] ，猜测 i <= k <= j 我们可能出现以下三种结果：
       1. k 就是答案，此时子问题的额外 cost = 0 ，当前位置总 cost  = k + 0;
       2. k 过大，此时我们的有效区间缩小为 [i , k - 1] 当前操作总 cost  = k + f[i][k - 1];
       3. k 过小，此时我们的有效区间缩小为 [k + 1 , j] 当前操作总 cost  = k + f[k + 1][j];
所以对于每个k， cost = k + max(f[i][k - 1], f[k + 1][j])

遍历k，则f[i][j] = min(k + max(f[i][k - 1], f[k + 1][j]))

初始化 f[i][i]不用选，cost为0

返回 f[1][n]
**/

class Solution {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = start; k < start + len - 1; k++) {
                    minCost = Math.min(minCost, k + Math.max(f[start][k - 1], f[k + 1][start + len - 1]));
                }
                f[start][start + len - 1] = minCost;
            }
        }
        
        return f[1][n];
    }
}
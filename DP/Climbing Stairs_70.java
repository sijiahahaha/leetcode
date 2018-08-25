/**
n阶楼梯，每次爬一层或两层，多少种方案

1.state f[i]爬过i有多少种方案
    int[] f = new int[n+1]     要爬完n-th才行，相当于爬到n+1
2.function
    f[i] = f[i - 1] + f[i - 2];

3.initialize
    f[0] = 1;
    f[1] = 1
4.answer
    f[n]  爬过n，到了n+1

**/

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n + 1; i ++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
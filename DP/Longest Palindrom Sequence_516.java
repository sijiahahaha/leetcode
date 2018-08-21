/**
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

找subsequence的最长回文串长度

**
subsequence：在字符串中提取字符，排列组合 
subset：子集，连续字符

1.state f[i][j] 表示字符串i~j中，最长长度
    int[][] f
2.function
   [ a  b    c d e   f  g]    
     i i+1          j-1 j

  i=j : f[i][j] = f[i+1][j-1]+2 表示i,j都在最长回文串里
  i!=j : f[i][j] = max( f[i+1][j], f[i][j+1], f[i+1][j-1]) 表示ij有至少一个不在回文串里

3.initialize
    f[i][i] = 1
4.answer
     f[0][len-1] 
**/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return 0;
        }
                
        //state
        int[][] f = new int[len][len];
        //initialize, f[k][k] = 1
        for (int k = 0; k < len; k++) {
            f[k][k] = 1;
        }
        //function
        for (int i = len-1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);                
                }
            }
        }
      
        //answer
        return f[0][len - 1];       
    }
}
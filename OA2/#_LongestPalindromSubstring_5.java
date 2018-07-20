/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

给了string，找substring的最长回文串长度

**
[bbbab]
subsequence：在字符串中提取字符，排列组合 [bbbb]是
substring：子集，连续字符 [bbbb]不是，因为不连续

1.state f[i][j] 表示字符串i~j是否为回文
    boolean [][] f
2.function
   [ a  b    c d e   f  g]    
     i i+1          j-1 j

  f[i][j] = f[i+1][j-1] && i=j

3.initialize
    f[i][i] = true
    f[i][i+1] = true if i = i+1
4.answer
     s.substring(maxStart,maxLen)
**/

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return "";
        }
        int maxStart = 0;
        int max = 1;
        //state
        boolean[][] f = new boolean[len][len];
        //initialize
        for (int i = 0; i < len; i++) {
            f[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            f[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));            
            if (f[i][i + 1]) {
                maxStart = i;
                max = 2;
            }
        }        
        
        //function
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j) && f[i+1][j-1] == true);
                if (f[i][j] && max < j - i + 1) {
                    maxStart = i;
                    max = j - i + 1;
                }
            }
        }
        //answer
        return s.substring(maxStart, maxStart + max);
    }
}

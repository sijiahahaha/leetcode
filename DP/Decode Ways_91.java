/**
DP: 只能有1位或两位构成（类似爬楼梯一步两步）
1.state f[i] 前i有多少种方案
    int[] f = new int[n+1]     
2.function
    f[i] = (if i valid)f[i - 1] + (if i-1 ~ i valid)f[i - 1];

3.initialize
    f[1] = 1 (if 1th valid)   or   0 (if not valid)
    f[0] = 1;  假设“10” ，f[2] = (if 2th valid)f[1]         +           (if 1th~2th valid)f[0]   =  f[0] = 1
                                not valid 因为“0” 不行                   valid 因为“10”行
    
4.answer
    f[n]  


优化： DP时只跟f[i - 1]和f[i - 1]有关。所以用两个int分别存f[i - 1] f[i - 1]， 每次更新给下一次用。

**/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] f = new int[len + 1];
        f[0] = 1;
        f[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i < len + 1; i++) {
            if (isValid(s.substring(i - 1, i))) {
                f[i] += f[i - 1];
            }
            if (isValid(s.substring(i - 2, i))) {
                f[i] += f[i - 2];
            }
        }
        
        return f[len];
    }
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num >= 1 && num <= 26) {
            return true;
        }
        return false;
    }
}
//优化 O(1) memory
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int c2 = 1; // f[i - 2]
        int c1 = s.charAt(0) != '0' ? 1 : 0;; // f[i - 1]
        
        for (int i = 2; i < len + 1; i++) {
            int f = 0;
            if (isValid(s.substring(i - 1, i))) {
                f += c1;
            }
            if (isValid(s.substring(i - 2, i))) {
                f += c2;
            }
            c2 = c1;
            c1 = f;
        }
        
        return c1;
    }
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num >= 1 && num <= 26) {
            return true;
        }
        return false;
    }
}
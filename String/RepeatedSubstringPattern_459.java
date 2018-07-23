/**  
Input: "abcabcabcabc"
Output: True

Input: "aba"
Output: False

满足重复字符串：长度可以被整除，长度小于一半
所以在前半部分，找长度可以被整除的字符串，构建重复串，对比是否相同
**/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String temp = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                int n = s.length() / i;
                for (int j = 0; j < n; j ++) {
                    sb.append(temp);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
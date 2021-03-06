/**
Implement atoi which converts a string to an integer.

去掉空格 s.trim()
如果开头为‘+’‘-’，设置对应sign
遍历str，num = num * 10 + str.charAt(index) - '0';
遇到不是数字break；num > Integer.MAX_VALUE break
**/


class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int index = 0;
        int sign = 1;
        if (str.charAt(index) == '+') {
            index ++;
        } else if (str.charAt(index) == '-') {
            index ++;
            sign = -1;
        }
        long num = 0;
        for (; index < str.length(); index ++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            } else {
                num = num * 10 + str.charAt(index) - '0';
                if (num >= Integer.MAX_VALUE) {
                    break;
                }
            } 
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
}
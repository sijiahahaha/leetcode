/**
Input: 121
Output: true

Input: -121
Output: false

负数 -> false
<10 -> true
构造reverse，看是否相同
**/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int rev = 0;
        int num = x;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev == num;
    }
}
/**
Input: 123
Output: 321

Input: -123
Output: -321
**/

class Solution {
    public int reverse(int n) {
        // write your code here
        if (n == 0 || n == Integer.MAX_VALUE || n == Integer.MIN_VALUE) {
            return 0;
        }
        boolean isneg = false;
        if (n < 0) {
            n = -n;
            isneg = true;
        }
        int res = 0;
        while (n != 0) {
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = 10 * res + n % 10;
            n = n / 10;
        }
        if (res > Integer.MAX_VALUE) {
            return 0;
        }
        return isneg == true ? -res : res;
        
    }
}
/**
计算每个char count，看如果超过一个奇数就false
**/

class Solution {
    public boolean canPermutePalindrome(String s) {
        int odd = 0;
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (int i : count) {
            if (i  % 2 == 1) {
                odd++;
            }
            if (odd > 1) {
                return false;
            }
        }
        return true;
    }
}


       
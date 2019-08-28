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

/*
HashSet , 有就删掉，没有就加入
最终size 小于等于1

*/
public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) return false;
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <= 1;
    }
}       
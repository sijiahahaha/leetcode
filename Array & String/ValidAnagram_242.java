/**  
Given two strings s and t , write a function to determine if t is an anagram of s.

分别计算s和t的char count，对比是否相同
**/
class Solution {
    public boolean isAnagram(String s, String t) {
         if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        
        int[] sCount = new int[256];
        int[] tCount = new int[256];
        for (char c : s.toCharArray()) {
            sCount[c]++;
        }
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        return true;
    }
}
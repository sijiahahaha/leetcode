/**
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.

用string中的char组成回文。区别大小写

1）可以用HashSet做， 最坏占用O(len)的空间
    遍历char，如果set中没有，就add(), 如果有就remove(), 最终剩下的是没有配对的。（没有配对考虑是否为0）
    结果返回 总数-没有配对+1

2) 计算每个字母出现的次数，根据奇偶数计算。 占用O(52)的空间
**/

//HashSet
class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }        
        HashSet<Character> set = new HashSet<Character>();       
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }       
        int remain = set.size();
        if (remain == 0) {
            return s.length();
        }        
        return s.length() - remain + 1;        
    }
}


//计算char出现次数
class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] charTimes = new int[52];
        for (char c : s.toCharArray()) {
            if (c < 'a') { //uppercase
                charTimes[c - 'A']++;
            } else {
                charTimes[c - 'a' + 26]++;
            }
        }
        
        int evenCount = 0;
        int oddCount = 0;
        for (int count : charTimes) {
            if (count % 2 == 0) {
                evenCount += count;
            } else {
                evenCount += count - 1;
                oddCount++;
            }
        }
        
        if (oddCount == 0) {
            return evenCount;
        } 
        
        return evenCount + 1;
    }
}
/**
sliding window 思想
先统计需要的char和count
遍历string，对于每个char，如果需要它，则match++。每包含一个数都需要--；
当达到window的长度，下一步，判断window第一个是否需要，扔出去之后对后续有何改变
**/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int curr = 0;
        int match = 0;
        while (curr < s.length()) {
            if (need[s.charAt(curr) - 'a'] >= 1) {
                match++;
            }
            need[s.charAt(curr) - 'a']--;
            curr++;
            
            if (match == p.length()) {
                result.add(start);
            }
            if (curr - start == p.length()) {
                if (need[s.charAt(start) - 'a'] >= 0) {
                    match--;
                }
                need[s.charAt(start) - 'a']++;
                start++;
            }
        }
        return result;
    }
}
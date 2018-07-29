/**  
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

sliding window思想
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
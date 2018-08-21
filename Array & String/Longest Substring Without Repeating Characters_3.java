/**  
Given a string, find the length of the longest substring without repeating characters.

两个指针start，end
用HashMap<Character, Integer> 存每个char上一次出现的index
遍历end
    如果end之前有出现过，start变为最靠近的位置: start = Math.max(start, map.get(s.charAt(end)) + 1);
    max为end-start+1, 更新map中的end: map.put(s.charAt(end), end);
**/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++){
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(s.charAt(end), end);
        }
        
        return max;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) return "";
        
        int[] need = new int[256];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int count = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (need[c] > 0) {
                count ++;
            }
            need[c] --;
            while (count == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    res = s.substring(left, i + 1);
                }
                
                char out = s.charAt(left++);
                need[out] ++;
                if (need[out] > 0) {
                    count --;
                }
            }
        }
        return res;
    }
}
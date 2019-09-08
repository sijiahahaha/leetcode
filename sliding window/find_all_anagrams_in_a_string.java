class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }
        
        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < p.length() - 1; i++) {
            char c = s.charAt(i);
            if (need[c - 'a'] > 0) {
                count++;
            }
            need[c - 'a']--;
        }
        
        for (int i = p.length() - 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (need[c - 'a'] > 0) {
                count++;
            }
            need[c - 'a']--;
            
            if (count == p.length()) {
                res.add(i - p.length() + 1);
            }
            
            char cout = s.charAt(i - p.length() + 1);
            
            need[cout - 'a']++;
            if (need[cout - 'a'] > 0) {
                count--;
            }
        }
        
        return res;
            
    }
}
class Solution {
    int[] need = new int[26];
    int match = 0;
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return true;
        if (s2 == null || s2.length() < s1.length()) return false;
    
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }
        
        
        for (int i = 0; i < s1.length() - 1; i++) {
            char c = s2.charAt(i);
            inQue(c);
        }
        
        for (int i = s1.length() - 1; i < s2.length(); i++) {
            char c = s2.charAt(i);
            inQue(c);
            
            if (match == s1.length()) {
                return true;
            }
            
            char cout = s2.charAt(i - s1.length() + 1);
            outQue(cout);
        }
        
        return false;
    }
    
    private void inQue(char c) {
        if (need[c - 'a'] > 0) {
            match++;
        }
        need[c - 'a']--;
    }
    
    private void outQue(char c) {
        need[c - 'a']++;
        if (need[c - 'a'] > 0) {
            match--;
        }
    }
}
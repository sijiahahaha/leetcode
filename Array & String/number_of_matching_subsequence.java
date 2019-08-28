class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        if (S == null || S.length() == 0 || words.length == 0) {
            return 0;
        }
        int count = 0;
        for (String word : words) {
            if (isSubsequence(S, word)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isSubsequence(String S, String word) {
        if (word == null) return true;
        if (S == null) return false;
        int i = 0;
        int j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length();
    }
}
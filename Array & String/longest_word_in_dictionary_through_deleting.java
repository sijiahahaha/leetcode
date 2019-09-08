class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) return s;
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) return a.charAt(0) - b.charAt(0);
                return b.length() - a.length();
            }
        });
        for (String word : d) {
            if (isSubsequence(s, word)) {
                return word;
            }
        }
        return "";
    }
    
    private boolean isSubsequence(String s, String word) {
        int i = 0; 
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) j++;
            i++;
        }
        return j == word.length();
    }
}
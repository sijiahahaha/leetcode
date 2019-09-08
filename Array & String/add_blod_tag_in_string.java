public class Solution {
    /**
     * @param s: a string
     * @param dict: a list of strings
     * @return: return a string
     */
    public String addBoldTag(String s, String[] dict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (String word : dict) {
            int len = word.length();
            for (int i = 0; i <= s.length() - len; i++) {
                if (s.charAt(i) == word.charAt(0) && s.substring(i, i + len).equals(word)) {
                    for (int j = 0; j < len; j++) {
                        set.add(i + j);
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(i) && !set.contains(i - 1)) sb.append("<b>");
            sb.append(s.charAt(i));
            if (set.contains(i) && !set.contains(i + 1)) sb.append("</b>");
            
        }
        
        return sb.toString();
        
    }
}
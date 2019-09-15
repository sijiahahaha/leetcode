word_pattern_ii.java 
public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        Map<Character, String> map = new HashMap<>();
		return dfs(pattern, 0, str, 0, map);
    }
    private boolean dfs(String pattern, int p, String str, int s, Map<Character, String> map) {
		if (p == pattern.length() && s == str.length()) return true;
		if (p >= pattern.length() || s >= str.length()) return false;

		char c = pattern.charAt(p);
		for (int i = s; i < str.length(); i++) {
			String t = str.substring(s, i - s + 1);
			if (map.containsKey(c) && map.get(c).equals(t)) {
				if (dfs(pattern, p + 1, str, i + 1, map)) return true;
			} else if (!map.containsKey(c)) {
				boolean find = false;
				for (char key : map.keySet()) {
					if (map.get(key).equals(t)) find = true;
				}
				if (!find) {
					map.put(c, t);
					if (dfs(pattern, p + 1, str, i + 1, map)) return true;
					map.remove(c);
				}
			}
		}
		return false;
	}
}
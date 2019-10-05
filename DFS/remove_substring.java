remove_substring.java
class Solution {
    public int min(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null) return 0;
        Map<String, Integer> map = new HashMap<>();
        return dfs(s, dict, map);
    }

    private int dfs(String s, Set<String> dict, Map<String, Integer> map) {
        if (map.containsKey(s)) return map.get(s);
        int minLen = s.length();
        for (String sub : dict) {
            int pos = s.indexOf(sub);
            while (pos != -1) {
                String newStr = s.substring(0, pos) + s.substring(pos + sub.length());
                int len = dfs(newStr, dict, map);
                minLen = Math.min(minLen, len);
            }
        }

        map.put(s, minLen);
        return minLen;
    }

}
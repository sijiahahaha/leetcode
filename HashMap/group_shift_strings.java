public class Solution {
    /**
     * @param strings: a string array
     * @return: return a list of string array
     */
    public List<List<String>> groupStrings(String[] strings) {
        // write your code here
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = shiftToKey(s);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private String shiftToKey(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int shift = s.charAt(0) - 'a';
        for (char c : s.toCharArray()) {
            char newChar = (char)(c - shift);
            if (newChar < 'a') newChar += 26;
            sb.append(newChar);
        }
        return sb.toString();
    }
}
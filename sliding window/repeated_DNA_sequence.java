class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 10) return res;
        Set<String> set = new HashSet<>();
        Set<String> allRes = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            char c = s.charAt(i);
            sb.append(c);
        }
        
        for (int i = 9; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            String key = sb.toString();
            if (set.contains(key)) {
                allRes.add(key);
            }
            set.add(key);
            sb.deleteCharAt(0);
        }
        
        for (String str : allRes) res.add(str);
        return res;
    }
    
}
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length <= 1) {
            return res;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (String word : words) {
            String mid = "";
            String need = reverse(word);
            if (map.containsKey(need) && map.get(need) != map.get(word)) {
                res.add(format(word, need, map));
            }
    
            int len = word.length();
            // (aba)""  &&  ""(aba)
            mid = word;
            need = "";
            if (isPalindrome(mid) && map.containsKey(need) && map.get(need) != map.get(word)) {
                res.add(format(word, need, map));
                res.add(format(need, word, map));
            }
        
            // (aba) da
            for (int i = 0; i < len - 1; i++) {
                mid = word.substring(0, i + 1);
                need = reverse(word.substring(i + 1));
                if (isPalindrome(mid) && map.containsKey(need) && map.get(need) != map.get(word)) {
                    res.add(format(need, word, map));
                } 
            }
            
            // ab (ada)
            for (int i = 1; i < len; i++) {
                mid = word.substring(i);
                need = reverse(word.substring(0, i));
                if (isPalindrome(mid) && map.containsKey(need) && map.get(need) != map.get(word)) {
                    res.add(format(word, need, map));
                } 
            }
        }
        
        return res;
        
    }
    
    private boolean isPalindrome(String s) {
        return s.equals(reverse(s));   
    }
    
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    private List<Integer> format(String a, String b, HashMap<String, Integer> map) {
        int idx1 = map.get(a);
        int idx2 = map.get(b);
        List<Integer> list = Arrays.asList(idx1, idx2);
        return list;
    }
}
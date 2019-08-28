
// Group Anagrams.java
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res = new ArrayList<>();
    	if (strs == null || strs.length == 0) return res;

    	Map<String, List<String>> map = new HashMap<>();
    	for (String str : strs) {
    		String key = getKey(str);
    		if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
    		map.get(key).add(str);
    	}

    	for (List<String> anagrams : map.values()) {
    		Collection.sort(anagrams);
    		res.add(new ArrayList<>(anagrams));
    	}
    	return res;
    }

    private String getKey(String str) {
    	char[] count = new char[26];
    	for (char c : str.toCharArray()) {
    		count[c - 'a']++;
    	}
    	return String.valueOf(count);
    }
}
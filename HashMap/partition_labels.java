partition_labels.java
 class Solution {
    public List<Integer> partition(String s) {
		List<Integer> res = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, i);
		}
		int start = 0;
		int last = 0;
		for (int i = 0; i < s.length(); i++) {
			last = Math.max(last, map.get(s.charAt(i)));
			if (i == last) {
				res.add(last - start + 1);
				start = last + 1;
			}
		}
		return res;
    }
 }
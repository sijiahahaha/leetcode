unique_substring.java
class Solution {
    public List<String> unique(String s, int k) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() < k) {
			return res;
		}
		Set<String> set = new TreeSet<>();
		for (int i = 0; i <= s.length() - k; i++) {
			set.add(s.substring(i, i + k));
		}
		for (String curr : set) {
			res.add(curr);
		}
		return res;
    }
}

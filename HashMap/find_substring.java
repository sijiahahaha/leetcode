find_substring.java
class Solution {
    public int find(String s, int k) {
		if (s == null || s.length == 0 || k == 0 || k > 26) return 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i <= s.length() - k; i++) {
			Set<Character> charSet = new HashSet<>();
			boolean legal = true;
			for (int j = i; j <= i + k - 1;; j++) {
				if (charSet.containsKey(s.charAt(j))) {
					legal = false;
					break;
				}
				charSet.add(s.charAt(j));
			}
			if (legal) {
				String curr = s.substring(i, i + k);
				set.add(curr);
			}

		}
		return set.size();
    }
}
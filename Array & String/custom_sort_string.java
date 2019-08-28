// custom sort string
class Solution {
	public String customSortString(String s, String t) {
		int[] count = new int[26];
		for (Character c : t.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (Character k : s.toCharArray()) {
			while (count[k - 'a'] > 0) {
				sb.append(k);
				count[k - 'a']--;
			}
		}
		for (Character c : t.toCharArray()) {
			while (count[c - 'a'] > 0) {
				sb.append(c);
				count[c - 'a']--;
			}
		}
		return sb.toString();

}
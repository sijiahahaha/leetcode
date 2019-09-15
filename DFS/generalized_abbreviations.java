generalized_abbreviations.java
class Solution {
	public List<String> generate(String word) {
		List<String> res = new ArrayList<>();
		if (word == null || word.length() == 0) return res;
		dfs(word, 0, 0, "", res);
		return res;
	}
	private void dfs(String word, int pos, int count, String curr, List<String> res) {
		if (pos == word.length()) {
			if (count > 0) curr += String.valueOf(count);
			res.add(curr);
			return;
		}

		dfs(word, pos + 1, count + 1, curr, res);
		dfs(word, pos + 1, 0, curr + (count > 0 ? String.valueOf(count) : "") + word.charAt(pos), res);
	}
}
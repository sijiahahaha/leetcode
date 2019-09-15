letter_case_permutation.java
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
		if (S == null || S.length() == 0) return res;
		dfs(S, 0, "", res);
		return res;
    }
    
    private void dfs(String S, int index, String curr, List<String> res) {
		if (index == S.length()) {
			res.add(curr);
			return;
		}
		char c = S.charAt(index);
		if (Character.isDigit(c)) {
			dfs(S, index + 1, curr + c, res);
		} else {
			c = Character.toLowerCase(c);
			dfs(S, index + 1, curr + c, res);
			c = Character.toUpperCase(c);
			dfs(S, index + 1, curr + c, res);
		}
	}
}
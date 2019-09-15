generate_parentheses.java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
		if (n == 0) return result;
		dfs(n, n, "", result);
		return result;
    }
    private void dfs(int left, int right, String curr, List<String> result) {
		if (left > right) return;
		if (left == 0 && right == 0) {
			result.add(curr);
			return;
		}
		if (left > 0) {
			dfs(left - 1, right, curr + "(", result);
		}

		if (right > 0) {
			dfs(left, right - 1, curr + ")", result);
		}
	}
}
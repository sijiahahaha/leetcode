combination_sum_iii.java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
		if (n == 0 || k == 0) return res;
		dfs(k, n, 1, 0, new ArrayList(), res);
		return res;
    }
    private void dfs(int k, int n, int index, int sum, List<Integer> curr, List<List<Integer>> res) {
		if (sum == n && curr.size() == k) {
			res.add(new ArrayList<>(curr));
			return;
		}
		for (int i = index; i <= 9; i++) {
			if (sum + i > n) continue;
			curr.add(i);
			dfs(k, n, i + 1, sum + i, curr, res);
			curr.remove(curr.size() - 1);
		}
	}
}
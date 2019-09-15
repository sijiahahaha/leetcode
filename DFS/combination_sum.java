combination_sum.java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0 || target < 0) return res;
		dfs(candidates, target, 0, 0, new ArrayList(), res);
		return res;
    }
    private void dfs(int[] candidates, int target, int index, int sum, List<Integer> curr, List<List<Integer>> res) {
		if (sum == target) {
			res.add(new ArrayList<>(curr));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (sum + candidates[i] > target) continue;
			curr.add(candidates[i]);
			dfs(candidates, target, i, sum + candidates[i], curr, res);
			curr.remove(curr.size() - 1);
		}
	}
}


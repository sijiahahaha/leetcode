combination_sum_ii.java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 0) return res;
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            curr.add(candidates[i]);
            dfs(candidates, target, i + 1, sum + candidates[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
increasing_subsequences.java 
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		boolean[] visited = new boolean[nums.length];
		int[] prev = get_prev(nums);
		dfs(nums, 0, visited, prev, new ArrayList<>(), res);
		return res;
    }
    private int[] get_prev(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] pre = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				pre[i] = map.get(nums[i]);
			} else {
				pre[i] = -1;
			}
			map.put(nums[i], i);
		}
		return pre;
	}
    private void dfs(int[] nums, int index, boolean[] visited, int[] prev, List<Integer> curr, List<List<Integer>> res) {
		if (curr.size() > 1) {
			res.add(new ArrayList<>(curr));
		}
		for (int i = index; i < nums.length; i++) {
			if (curr.size() > 0 && nums[i] < nums[index - 1]) continue;
			if (prev[i] != -1 && !visited[prev[i]] && (curr.size() == 0 || prev[i] > index - 1))
				continue;
			curr.add(nums[i]);
			visited[i] = true;
			dfs(nums, i + 1, visited, prev, curr, res);
			visited[i] = false;
			curr.remove(curr.size() - 1);
		}
	}
}
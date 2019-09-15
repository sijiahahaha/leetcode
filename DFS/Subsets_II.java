class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(curr));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            dfs(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
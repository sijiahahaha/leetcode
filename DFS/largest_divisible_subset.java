largest_divisible_subset.java  
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		int[] index = new int[nums.length];
		Arrays.fill(dp, 1);
		Arrays.fill(index, -1);
		int max_dp = 1;
		int max_index = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					index[i] = j;
				}
			}
			if (max_dp < dp[i]) {
				max_dp = dp[i];
				max_index = i;
			}
		}
		for (int i = max_index; i != -1; i = index[i]) {
			res.add(nums[i]);
		}
		return res;
    }
}
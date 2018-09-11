/**
dfs(int[] nums, int k, boolean[] visited, int start, int currSum, int target)
一个个子集凑，直到只剩k=1个，则为true
对于每个子集，先判断visited，再判断加入子集后，剩余能否满足dfs
**/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, k, visited, 0, 0, target);
    }
    private boolean dfs(int[] nums, int k, boolean[] visited, int start, int currSum, int target) {
        if (k == 1) {
            return true;
        }
        if (currSum == target) {
            return dfs(nums, k - 1, visited, 0, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, k, visited, i + 1, currSum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
class Solution {
    int[] prefixSum = null;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (prefixSum == null || i < 0 || j > prefixSum.length - 1) return -1;
        if (i == 0) return prefixSum[j];
        return prefixSum[j] - prefixSum[i - 1];
    }
}
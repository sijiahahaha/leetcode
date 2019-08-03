class Solution {
    public int minSubarrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= k) {
                minLen = Math.min(minLen, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return minLen;

    }
}
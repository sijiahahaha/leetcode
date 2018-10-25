/**
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6

找到subarray中sum最大的值

1.state f[i]表示以i结尾的subarray的最大sum
    int[] f
2.function
    f[i] = f[i - 1] >= 0 ? nums[i] + f[i - 1] : nums[i]      如果前面的sum小于0，则不带前面的，重新开始

3.initialize
    f[0] = nums[0]  
4.answer
     maxSum

**/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int maxSum = f[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = f[i-1] >= 0 ? nums[i] + f[i - 1] : nums[i];
            maxSum = Math.max(maxSum, f[i]);
        }
        return maxSum;
    }
}
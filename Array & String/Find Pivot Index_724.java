/**
算出total sum
遍历，对于每个k， 如果 preSum + k + preSum = total，则k符合
**/
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        int preSum = 0;
        for (int j = 0; j < nums.length; j++) {
            if (preSum * 2 + nums[j] == total) {
                return j;
            }
            preSum += nums[j];
        }
        return -1;
    }
}


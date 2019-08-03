class Solution {
    public boolean find132patter(int[] nums) {
        int small = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] <= small) {
                small = nums[j];
                continue;
            }
            for (int k = nums.length - 1; k > j; k--) {
                if (small < nums[k] && nums[j] > nums[k]) return true;
            }

        }
        return false;
    }
}
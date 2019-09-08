public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        boolean canFlip = true;
        int maxLen = 0;
        int start = 0;
        int next = -1;
        while (nums[start] == 0 && start < nums.length) {
            start++;
        }
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                maxLen = Math.max(maxLen, i - start + 1);
                continue;
            }
            if (canFlip) {
                canFlip = false;
                next = i + 1;
                maxLen = Math.max(maxLen, i - start + 1);
                continue;
            }
            start = next;
            next = i + 1;
            maxLen = Math.max(maxLen, i - start + 1);
            
        }
        
        return maxLen;
    }
}
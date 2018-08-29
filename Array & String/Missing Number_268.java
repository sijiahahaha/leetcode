/**
目的是换成 nums[i] = i
所以对于每一个nums[i]， 不满足就一直换第i位和第nums[i]位，swap(i, nums[i]);
最后遍历，看哪位不满足
**/
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int i = 0;
        while (i < len) {
            while (nums[i] != i && nums[i] < len) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
            i++;
        }
        for (int j = 0; j < len; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return len;
    }
}
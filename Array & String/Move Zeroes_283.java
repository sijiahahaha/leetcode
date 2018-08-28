/**
2 pointer： left指向zero， right指向non-zero
遍历数字，遇到nonzero， swap(left, right), left++, right继续找下一个nonzero
right 肯定>= left， left指在right跳过的点，肯定为0，所以left到right中间一段都是0
**/
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
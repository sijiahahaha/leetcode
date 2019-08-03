class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        int size = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[size - 2]) {
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }
}

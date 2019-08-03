class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        int size = 0;
        for (int num : nums) {
            if (num != nums[size]) {
                size++;
                nums[size] = num;
            }
        }
        return size + 1;
    }
}

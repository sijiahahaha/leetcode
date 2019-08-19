public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) return;
        int[] temp = nums;
        Arrays.sort(temp);
        int mid = (nums.length + 1) / 2;
        int end = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? nums[mid--] : nums[end--];
        }
    }
}
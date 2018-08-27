/** 
给定一个array和一个offset，根据offset旋转string(从左向右旋转)
利用 (A^T B^T)^T = (AB)^T = BA
**/
class Solution {
    public void rotate(int[] nums, int k) {      
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
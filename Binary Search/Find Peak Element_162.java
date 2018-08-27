/**
找到array中的任意一个峰值
二分法
    如果mid < mid + 1 , 递增， 后面有峰值， start = mid
    如果mid < mid - 1 , 递减， 前面有峰值， end = mid
    如果 mid比前后都小， 前后都有峰值，随意
**/
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums[1] < nums[0]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int start = 1;
        int end = nums.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }
}
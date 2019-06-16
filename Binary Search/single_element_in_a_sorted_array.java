/*
if n is even , n should be same as n+1
if n is odd, n should be same as n-1
===> n should be same as n^1 (n XOR 1) 

if true, means first n numbers are paired, search right side,
if not true, means the single element placed in the left

*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length % 2 == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int pair = mid ^ 1;
            if (nums[mid] == nums[pair]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (left == 0 || nums[left] != nums[left - 1]) {
            return nums[left];
        }
        return nums[right];
    }
}
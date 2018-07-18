/**
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

遍历a，对后半部分two sum closest，target=-a
每次记录best diff
**/


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int bestDiff = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;
        if (nums == null || nums.length < 3) {
            return bestDiff;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            int currTarget = target - nums[i];
            while (left < right) {
                int currDiff = Math.abs(nums[left] + nums[right] - currTarget);
                if (currDiff < bestDiff) {
                    bestDiff = currDiff;
                    bestSum = nums[i] + nums[left] + nums[right];
                }               
                if (nums[left] + nums[right] < currTarget) {
                    left ++;
                } else {
                    right --;
                }
            }
        }        
        return bestSum;       
    }
}



// two sum closest
class Solution {
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int bestDiff = Integer.MAX_VALUE;

        while (left < right) {
            int currDiff = Math.abs(nums[left] + nums[right] - target);
            bestDiff = Math.min(bestDiff, currDiff);

            if (nums[left] + nums[right] < target) {
                left ++;
            } else {
                right --;
            }
        }

        return bestDiff;
    }
}
/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

# unsorted, find all solutions, return abc

遍历a，对后半部分two sum，target=-a
找到之后，要继续，跳过重复的
**/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        //sort
        Arrays.sort(nums);
        //for(a)
        for (int i = 0; i < nums.length - 2; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }            
            //two sum
            int left = i + 1;
            int right = nums.length -1;
            int target = -nums[i];
            twoSum(results, nums, left, right, target);            
        }     
               
        return results;
    }
    
    private void twoSum(List<List<Integer>> results, int[] nums, int left, int right, int target) {
        while (left < right) {
            if (nums[left] + nums[right] == target){
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                
                left ++;
                right --;
                
                while (left < right && nums[left] == nums[left - 1]) {
                    left ++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right --;
                }
            } else if (nums[left] + nums[right] < target) {
                left ++;
            } else {
                right --;
            }           
        }
    }
        
}
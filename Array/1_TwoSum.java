/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

# unsorted, only one solution, each elements use once

sort + 2pointer:  O(nlogn) time, O(1) space
  1.sort
  2.两个指针，一头一尾
  3.L+R>T: R --
    L+R<T: L ++
  4.L+R=T: return
    or LR相遇，return


HashMap: O(n) time, O(n) space
  遍历nums，若 target-nums[i] 在map里，则 int[] result = {map.get(target-nums[i]), i}
           若不在，map.put(nums[i], i)
**/


// sort + 2pointer
class Solution {
    class Pair {
        Integer value;
        Integer index;
        
        Pair(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }
        
        Integer getValue() {
            return this.value;
        }
    }
    
    class valueComp implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return p1.getValue().compareTo(p2.getValue());
        }
    }    
    
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Pair[] numsPair = new Pair[len];
        for (int i = 0; i < len; i++) {
            numsPair[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(numsPair, new valueComp());
        int left = 0;
        int right = len-1;
        while (left < right) {
            if (numsPair[left].getValue() + numsPair[right].getValue() == target) {
                int idx1 = numsPair[left].index;
                int idx2 = numsPair[right].index;
                int[] result = new int[2];
                result[0] = Math.min(idx1, idx2);
                result[1] = Math.max(idx1, idx2);
                
                return result;
            } else if (numsPair[left].getValue() + numsPair[right].getValue() < target) {
                left ++;
            } else {
                right --;
            }
        }
        
        return null;
    }
}


// Hash Map
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                int[] result = {map.get(target - nums[i]), i};
                return result;                                       
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
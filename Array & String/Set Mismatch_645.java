/**
unsorted数组，由1～n组成，其中有一个数缺少了，另一个数出现了两次。
找出出现两次的数和缺少的数

O(1) space: 
1. 遍历，遇到一个数，就把对应位置的数变为负数。 如果已经为负数了，则说明之前已经遇到过了，则为重复
2. 再遍历， 遇到>0的数，说明对应位置的数没有出现过
**/


/class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        for (int num : nums) {
            if (nums[Math.abs(num)-1] < 0) {
                result[0] = Math.abs(num);
            } else {
                nums[Math.abs(num)-1] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
            }
        }
        
        return result;
    }   
}
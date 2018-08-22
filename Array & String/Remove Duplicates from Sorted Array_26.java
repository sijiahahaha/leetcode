/**  
Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.
去掉重复，得到length
O(1) memory

int size = 0; 遍历nums； 每找到一个nums[i] != nums[size], size++, 并把nums[size]赋值为nums[i] 

**/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                size++;
                nums[size] = nums[i];
            }
        }
        return size+1;
    }
}
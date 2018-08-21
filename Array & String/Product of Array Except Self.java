/**  
 result = left * right
 分别从左和右遍历，迭乘
**/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++){
            result[i] = 1;
        } 
        int left = 1, right = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length - 1; i++, j--) {
            left *= nums[i];
            right *= nums[j];
            result[i + 1] *= left;
            result[j - 1] *= right;
        }
        return result;
    }
}
/**
int 第一大，第二大，第三大
遍历，实时更新
**/
class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array can't be null");
        }
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) {
                continue;
            }
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null ||  num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null ||  num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
        
        
        
        
        
    }
}
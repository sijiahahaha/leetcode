/**
[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]


                #
        #       # #   #
    #   # #   # # # # # #
  0 1 0 2 1 0 1 3 2 1 2 1  
  l                     r
  找到两条边，中间可以存最多雨水   ->   min(left, right) * (right - left)

  双指针， 计算存水量
  如果left小，left++； 如果right小，right--
**/

class Solution {
    private int computeArea(int left, int right, int[] height) {
        return (right - left) * Math.min(height[left], height[right]);
    }
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        
        while (left < right) {
            max = Math.max(max, computeArea(left, right, height));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--; 
            }
        }
        return max;
    }
}
/**
[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]


                #
        #       # #   #
    #   # #   # # # # # #
  0 1 0 2 1 0 1 3 2 1 2 1  
  l                     r


  每个格存多少，取决于两边矮的。
  所以每次都先看矮的
     左边： 取决于左边的最高， 最高-自己
     右边： 取决于右边的最高， 最高-自己
**/

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int leftLeftMax = 0, rightRightMax = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                leftLeftMax = Math.max(leftLeftMax, height[left]);
                water += leftLeftMax - height[left];
                left++;
            } else {
                rightRightMax = Math.max(rightRightMax, height[right]);
                water += rightRightMax - height[right];
                right--;
            }
        }
        
        return water;
    }
}
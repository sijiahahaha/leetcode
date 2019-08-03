 /*
 * f(x) = ax^2 + bx + c
 *  - a>0, two side > middle
 *  - a<0, two side < middle
 *  - a=0, b>0, b<0, line ......
 *
 *
 *
 */

import java.util.Arrays;
class Solution {
    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        int idx = a >= 0 ? nums.length - 1 : 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (a >= 0) {
                result[idx--] = cal(nums[left], a, b, c) >= cal(nums[right], a, b, c) ? cal(nums[left++], a, b, c) : cal(nums[right--],     a, b, c);
            } else {
                result[idx++] = cal(nums[left], a, b, c) >= cal(nums[right], a, b, c) ? cal(nums[right--], a, b, c) : cal(nums[left++],     a, b, c);
            }
        }
        return result;
    }

    private static int cal(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}

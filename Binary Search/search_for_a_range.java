/**
[5, 7, 7, 8, 8, 8, 10] target=8
return [3,5]

binary search twice

first time find smallest target
second time find largest target in the right side
 **/
import java.util.Arrays;
class Solution {
    public static int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        int[] range = new int[2];
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (A[left] == target) {
            range[0] = left;
        } else if (A[right] == target) {
            range[0] = right;
            left = right;
        } else {
            return new int[]{-1, -1};
        }

        right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (A[right] == target) {
            range[1] = right;
        } else {
            range[1] = left;
        }
        return range;


    }
}
class TEST {
    public static void main (String[] args) {
        int[] letters = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = Solution.searchRange(letters, 8);
        System.out.println(Arrays.toString(result));

    }
}
~
~

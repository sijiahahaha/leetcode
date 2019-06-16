 /**
 find min element in a rotated sorted array

 compare mid and right
 **/

class Solution {
    public static int findMin(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = num.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (num[mid] > num[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(num[left], num[right]);

    }
}
class TEST {
    public static void main (String[] args) {
        int[] letters = new int[]{4, 5, 6, 7, 0, 1, 2};
        int result = Solution.findMin(letters);
        System.out.println(result);

    }
}

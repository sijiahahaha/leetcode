 /**
 find min element in a rotated sorted array
 has duplicate

 compare mid and right
 if mid == right, can remove right, will not change patten

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
            if (num[mid] == num[right]) {
                right = right - 1;
            } else if (num[mid] > num[right]) {
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
        int[] letters = new int[]{3, 1, 2, 3, 3, 3, 3};
        int result = Solution.findMin(letters);
        System.out.println(result);

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public static List<Integer> findClosetElements(int[] arr, int k, int x) {
        if (arr == null || arr.length < k) {
            return new ArrayList<Integer>();
        }

        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(arr[left + i]);
        }
        return result;
    }

}

/**
二分法，将mid带入guess(mid)，看结果是0，1，-1，对应三种情况
**/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } 
            if (result == 1) {
                start = mid + 1;
            } else if (result == -1) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
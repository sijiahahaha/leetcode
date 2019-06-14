/**
sorted char array, find smallest letter greater than target.
if larger then char[end], return char[0]
 **/
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int left = 0;
        int right = letters.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (letters[left] > target) {
            return letters[left];
        } else if (letters[right] > target) {
            return letters[right];
        }
        return letters[0];
    }
}

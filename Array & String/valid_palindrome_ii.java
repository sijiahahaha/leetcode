

// Valid Palindrome II.java
class Solution {
    public boolean validPalindrome(String s) {
    	if (s == null || s.length() <= 2) return true;
    	return helper(s, 0, s.length() - 1, true);
    }

    private boolean helper(String s, int left, int right, boolean canDelete) {
    	while (left < right) {
    		if (s.charAt(left) == s.charAt(right)) {
    			left++;
    			right--;
    			continue;
    		} else if (canDelete) {
    			return helper(s, left + 1, right, false) || helper(s, left, right - 1, false);
    		}
    		return false;
    	}
    	return true;

    }
}

// Valid Palindrome.java
public class Solution {
    public boolean isPalindrome(String s) {
    	if (s == null || s.length() <= 1) return true;

    	String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    	int left = 0;
    	int right = str.length() - 1;
    	while (left < right) {
    		if (str.charAt(left) != str.charAt(right)) return false;
    		left++;
    		right--;
    	}
    	return true;
    }
}

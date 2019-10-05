number_of_subsequence_of_form.java
public class Solution {
    public int countSubsequences(String s) {
        // write your code here
        if (s == null || s.length() == 0) return 0;
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
				case 'a':
					aCount = 2 * aCount + 1;
					break;
				case 'b':
					bCount = 2 * bCount + aCount;
					break;
				case 'c':
					cCount = 2 * cCount + bCount;
					break;
				default:
					continue;
			}
		}
		return cCount;
    }
}
Monotone_Increasing_Digits.java
// find the first pos i that not n[i] > n[i + 1]
// trace back to the first of same number n[k] = n[k + 1] = ... = n[i]
// after k, turn to 0
// minues 1
class Solution {
	public int mono(int num) {
		String s = num + "";
		char[] chars = s.toCharArray();
		int pos = -1;
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] > chars[i + 1]) {
				pos = i;
				break;
			}
		}
		if (pos == -1) return num;
		while (pos - 1 >= 0 && chars[pos - 1] == chars[pos]) {
			pos --;
		}
		for (int i = pos + 1; i < chars.length; i++) {
			chars[i] = '0';
		}
		return Integer.parseInt(new String(chars)) - 1;

	}

}
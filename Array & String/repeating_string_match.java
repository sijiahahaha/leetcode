
// Repeated String Match
class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (b == null || b.length() == 0) return 1;
		if (a == null || a.length() == 0) return -1;

		int repeat = 1;
        String copy = a;
		while (a.length() < b.length()) {
			a += copy;
			repeat ++;
		}

		if (a.contains(b)) return repeat;
		a += copy;
		return a.contains(b) ? repeat + 1 : -1;
    }
}
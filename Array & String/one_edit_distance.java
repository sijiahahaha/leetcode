
// one edit distance
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1 || s == null || t == null || s.equals(t)) {
			return false;
		}
        s = s.toLowerCase();
        t = t.toLowerCase();
		int size = Math.min(s.length(), t.length());
		for (int i = 0; i < size; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				return compareStr(s, t, i, i + 1) || compareStr(s, t, i + 1, i) || compareStr(s, t, i + 1, i + 1);
			}
		}
		return true;
    }
    private boolean compareStr(String s, String t, int i, int j) {
		return s.substring(i).equals(t.substring(j));
	}

}
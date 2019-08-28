// license key formatting
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
        int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == '-') {
				continue;
			}
			if (c >= 'a' && c <= 'z') {
				c -= 32;
			}
			sb.insert(0, c);
            count++;
			if (count % k == 0) {
				sb.insert(0, '-');
			}
		}

		if (sb.length() != 0 && sb.charAt(0) == '-') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
    }
}
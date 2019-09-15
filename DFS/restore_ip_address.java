restore_ip_address.java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
		if (s == null || s.length() < 4 || s.length() > 12) return res;
		dfs(s, 4, "", res);
		return res;
    }
    private void dfs(String s, int k, String curr, List<String> res) {
		if (k == 0) {
            if (s.length() == 0) {
                res.add(curr.substring(0, curr.length() - 1));
            }
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (s.length() >= i && isValid(s.substring(0, i))) {
				dfs(s.substring(i), k - 1, curr + s.substring(0, i) + '.', res);
			}
		}
	}

	private boolean isValid(String s) {
		if (s == null || s.length() == 0 || s.length() > 3) return false;
		if (s.length() > 1 && s.charAt(0) == '0') return false;
		if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) return false;
		return true;
	}
}
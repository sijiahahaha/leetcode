palindrome_permutation_ii.java
public class Solution {
    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
     */
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) return res;
		int[] map = new int[256];
		for (char c : s.toCharArray()) {
			map[c]++;
		}
		String half = "";
		String mid = "";
		for (int i = 0; i < 256; i++) {
			if (map[i] % 2 == 1) {
				mid += (char)i;
				map[i]--;
			}
			if (mid.length() > 1) return res;
			map[i] = map[i] / 2;
		}
		dfs(s, map, half, mid, res);
		return res;
    }
    private void dfs(String s, int[] map, String half, String mid, List<String> res) {
		if (half.length() * 2 + mid.length() == s.length()) {
			res.add(half + mid + reverse(half));
			return;
		}
		for (int i = 0; i < 256; i++) {
			if (map[i] > 0) {
				half += (char)i;
				map[i]--;
				dfs(s, map, half, mid, res);
				map[i]++;
				half = half.substring(0, half.length() - 1);
			}
		}
	}

	private String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
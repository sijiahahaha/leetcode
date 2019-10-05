loud_and_rich.java
public class Solution {
    /**
     * @param richer: the richer array
     * @param quiet: the quiet array
     * @return: the answer
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // Write your code here.
        Map<Integer, List<Integer>> map = new HashMap<>();
		int[] ans = new int[quiet.length];
		Arrays.fill(ans, -1);

		for (int[] pair : richer) {
			int rich = pair[0];
			int poor = pair[1];
			if (!map.containsKey(poor)) map.put(poor, new ArrayList<>());
			map.get(poor).add(rich);
		}

		for (int i = 0; i < quiet.length; i++) {
			dfs(i, map, quiet, ans);
		}
		return ans;
    }
    private int dfs(int curr, Map<Integer, List<Integer>> map, int[] quiet, int[] ans) {
		if (ans[curr] != -1) return ans[curr];
		ans[curr] = curr;
		if (!map.containsKey(curr)) return ans[curr];
		
		List<Integer> richers = map.get(curr);
		for (int rich : richers) {
			int can = dfs(rich, map, quiet, ans);
			if (quiet[can] < quiet[ans[curr]]) {
				
				ans[curr] = can;
			}
		}
		return ans[curr];

	}
}
combinations.java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
		if (k <= 0 || n < k) return res;
		dfs(n, k, 1, new ArrayList<>(), res);
		return res;
        
        

    }
    private void dfs(int n, int k, int index, List<Integer> curr, List<List<Integer>> res) {
		if (curr.size() == k) {
			res.add(new ArrayList<>(curr));
			return;
		}
		for (int i = index; i <= n; i++) {			
            curr.add(i);
			dfs(n, k, i + 1, curr, res);
			curr.remove(curr.size() - 1);
		}
	}
}
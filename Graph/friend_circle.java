friend_circle.java  
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0)
			return 0;
		boolean[] visited = new boolean[M.length];
		int res = 0;
		for (int i = 0; i < M.length; i++) {
			if (visited[i]) continue;
			res++;
			dfs(M, i, visited);
		}
		return res;
    }
    private void dfs(int[][] M, int i, boolean[] visited) {
		visited[i] = true;
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] != 1 || visited[j]) continue;
			dfs(M, j, visited);
		}
	}
}
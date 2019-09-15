n_queens.java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
		if (n <= 0) return res;
		dfs(n, new ArrayList<>(), res);
		return res;
    }
    private void dfs(int n, List<Integer> pos, List<List<String>> res) {
		if (pos.size() == n) {
			res.add(createBoard(pos));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValidate(pos, i)) {
				pos.add(i);
				dfs(n, pos, res);
				pos.remove(pos.size() - 1);
			}
		}
	}
    private boolean isValidate(List<Integer> pos, int newCol) {
		int newRow = pos.size();
		for (int row = 0; row < pos.size(); row++) {
			int col = pos.get(row);
			if (col == newCol || Math.abs(row - newRow) == Math.abs(col - newCol)) {
				return false;
			}
		}
		return true;
	}
    private List<String> createBoard(List<Integer> pos) {
		List<String> board = new ArrayList<>();
		for (int row = 0; row < pos.size(); row++) {
			StringBuilder sb = new StringBuilder();
			for (int col = 0; col < pos.size(); col++) {
				if (col == pos.get(row)) sb.append('Q');
				else sb.append('.');
			}
			board.add(sb.toString());
		}
		return board;
	}
}
class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
            return new int[0][0];
        }

        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
        int[] dx = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = M[i][j];
                int count = 1;
                for (int k = 0; k < 8; k++) {
                    if (isValid(i + dx[k], j + dy[k], m, n)) {
                        sum += M[i + dx[k]][j + dy[k]];
                        count++;
                    }
                }
                res[i][j] = sum / count;
            }
        }

        return res;
    }
    private boolean isValid(int x, int y, int m , int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
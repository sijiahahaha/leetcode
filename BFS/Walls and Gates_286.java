/**
1.dfs
遍历所有点，找到gate时，对其上下左右遍历，依次加dist（注意判断dist是否大于当前值，大于就不变）
2.bfs
先把所有gate（0）放入queue（qx存x坐标，qy存y坐标）
对于每一个gate，往上下左右方向递归，如果下一步是INF，那么把下一步变为这一步加1，rooms[nx][ny] = rooms[cx][cy] + 1;
**/
//dfs
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int dist) {
        int m = rooms.length;
        int n = rooms[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] == -1 || dist > rooms[i][j]) {
            return;
        }
        
        rooms[i][j] = dist;
        dfs(rooms, i + 1, j, dist + 1);
        dfs(rooms, i, j + 1, dist + 1);
        dfs(rooms, i - 1, j, dist + 1);
        dfs(rooms, i, j - 1, dist + 1);
    }
}




//bfs
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                
                if (0 <= nx && nx < m && 0 <= ny && ny < n && rooms[nx][ny] == Integer.MAX_VALUE) {
                    qx.offer(nx);
                    qy.offer(ny);
                    rooms[nx][ny] = rooms[cx][cy] + 1;
                }
            }
        }
    }
}
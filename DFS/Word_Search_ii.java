class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) 
            return res;
        int m = board.length;
        int n = board[0].length;
        Map<String, Boolean> map = getMap(words);
        Set<String> set = new HashSet<String>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, visited, "", map, set);            
            }
        } 
        
        return new ArrayList<String>(set);
    }
    
    private Map<String, Boolean> getMap(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String str = word.substring(0, i + 1);
                if (!map.containsKey(str)) {
                    map.put(str, false);
                }
            }
            map.put(word, true);   
        }
        return map; 
    }
    
    private void dfs(char[][] board, int x, int y, boolean[][] visited, String curr, Map<String, Boolean> map, Set<String> set) {
        int m = board.length;
        int n = board[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (visited[x][y]) return;
        curr += board[x][y];
        if (!map.containsKey(curr)) return;
        visited[x][y] = true;
        if (map.get(curr)) set.add(curr);
        dfs(board, x + 1, y, visited, curr, map, set);
        dfs(board, x - 1, y, visited, curr, map, set);
        dfs(board, x, y + 1, visited, curr, map, set);
        dfs(board, x, y - 1, visited, curr, map, set);
        visited[x][y] = false;
        return;
        
    }
}
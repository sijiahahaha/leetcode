class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0 || graph[0] == null || graph[0].length == 0) {
            return res;
        }
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(graph, 0, curr, res);
        return res;
    }
    private void dfs(int[][] graph, int node, List<Integer> curr, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int nextNode : graph[node]) {
            curr.add(nextNode);
            dfs(graph, nextNode, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
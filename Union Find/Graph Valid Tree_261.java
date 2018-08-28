/**
valid tree --> edges = nodes - 1 && 无环
利用UnionFind找有没有环： 如果find(a) == find(b), 说明ab根相同，若ab再链接，则形成环
**/
class Solution {
    public class UnionFind {
        int[] f;
        //初始化，所有元素孤立，自己为一个集合
        public UnionFind(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = -1;
            }
        }
        //合并： 找到根，把小集合并到大集合里
        public void union (int a, int b) {
            a = find(a);
            b = find(b);
            if (f[a] < f[b]) {
                f[a] += f[b];
                f[b] = a;
            } else {
                f[b] += f[a];
                f[a] = b;
            }
        }
        //找根：如果f[x]小于零，则本身为根。否则一直往上找，同时路径压缩
        public int find(int x) {
            if (f[x] < 0) {
                return x;
            }
            f[x] = find(f[x]);
            return f[x];
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length != n - 1) {
            return false;
        }
        
        UnionFind tree = new UnionFind(n);
        for (int[] edge : edges) {
            if (tree.find(edge[0]) == tree.find(edge[1])) { //有环
                return false;
            } else {
                tree.union(edge[0], edge[1]);
            }
        }
        return true;
    }
}
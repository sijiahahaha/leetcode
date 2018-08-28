/**
Union Find
一个operation 添加进UnionFind2D型的islands. 看四个方向上islands里parent 对应的值，若是大于0, 就find是不是在一个根下，若不在，就union起来. 四个direction走完，把islands的当前count加入res中。

为什么Union Find 的parent size 是m*n+1 而不是m*n呢? 因为parent[i] = 0时默认没有parent, 若index从0开始, 那么parent[i] = 0时无法判别是没有parent, 还是parent是0.

Time Complexity: O(k*logmn). Space: O(mn).
**/

class Solution {
    int [][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if(m == 0 || n == 0 || positions == null || positions.length == 0){
            return res;
        }
        
        UnionFind2D islands = new UnionFind2D(m, n);
        for(int [] row : positions){
            int p = islands.add(row[0],row[1]);
            for(int [] dir : directions){
                int x = row[0] + dir[0];
                int y = row[1] + dir[1];
                int q = islands.getParent(x,y);
                if(q > 0 && !islands.find(p,q)){
                    islands.union(p,q);
                }
            }
            res.add(islands.size());
        }
        return res;
    }
}

class UnionFind2D{
    private int [] parent;
    private int [] size;
    private int count, m, n;
    
    public UnionFind2D(int m, int n){
        this.m = m;
        this.n = n;
        this.count = 0;
        parent = new int[m*n+1];
        size = new int[m*n+1];
    }
    
    private int getIndex(int i, int j){
        return i*n + j + 1; 
    }
    
    public int add(int i, int j){
        int index = getIndex(i,j);
        count++;
        parent[index] = index;
        size[index] = 1;
        return index;
    }
    
    public int getParent(int i, int j){
        if(i < 0 || i>=m || j<0 || j>=n){
            return 0;
        }
        return parent[getIndex(i,j)];
    }
    
    public int size(){
        return this.count;
    }
    
    public boolean find(int p, int q){
        return root(p) == root(q);
    }
    
    private int root(int i){
        if(parent[i] == 0){
            return i;
        }
        while(i != parent[i]){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(size[i] < size[j]){
            parent[i] = j;
            size[j] += size[i];
        }else{
            parent[j] = i;
            size[i] += size[j];
        }
        count--;
    }
}


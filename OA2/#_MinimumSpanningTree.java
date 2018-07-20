/**
Given a list of Connections, which is the Connection class (the city name at both ends of the edge and a cost between them), find some edges, connect all the cities and spend the least amount.
Return the connects if can connect all the cities, otherwise return empty list.
给定一个graph之类的，有node，edge，cost，求一条最短的走完的路线

1. 按照edge(cost) 从小到大排序
2. 生成树：Union find 
3. 最后检查是否有环 应该edge size == node - 1
**/

/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    
    public class UFS {
        int[] f;
        
        public UFS(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = -1;
            }
        }
        
        public void union(int a, int b) {
            a = find(a); // find set root of a
            b = find(b);
            
            if (f[a] < f[b]) { //set a is larger than set b
                f[a] += f[b];
                f[b] = a;
            } else {
                f[b] += f[a];
                f[a] = b;
            }
        }
        
        public int find(int x) {
            if (f[x] < 0) { //x is the root
                return x;
            }
            f[x] = find(f[x]);
            return f[x];
        }
    }
    
    public List<Connection> lowestCost(List<Connection> connections) {
        List<Connection> result = new ArrayList<>();
        Collections.sort(connections, new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost != b.cost) {
                    return a.cost - b.cost;
                }
                if (a.city1.equals(b.city1)) {
                    return a.city2.compareTo(b.city2);
                }
                return a.city1.compareTo(b.city1);
            }
        });
        
        UFS ufs = new UFS(connections.size() * 2);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int count = 0;
        
        for (Connection con : connections) {
            if (!map.containsKey(con.city1)) {
                map.put(con.city1, count++);
            }
            if (!map.containsKey(con.city2)) {
                map.put(con.city2, count++);
            }
            
            int c1 = map.get(con.city1);
            int c2 = map.get(con.city2);
            if (ufs.find(c1) != ufs.find(c2)) { //different set, save to result, union
                result.add(con);
                ufs.union(c1, c2);
            }
        }
        
        if (result.size() != count - 1) {
            return new ArrayList<>();
        }
        return result;
    }
    
}
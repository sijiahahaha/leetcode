/**
1. 按照edge(cost) 从小到大排序
2. 生成树：Union find 
3. 最后检查是否有环

**/

import java.util.ArrayList;
import java.util.HashMap;

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
    int n = 0;

    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        List<Connection> ans = new ArrayList<>();
        UFS ufs = new UFS(connections.size() * 2);

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

        for (Connection item : connections) {
            int c1 = getID(item.city1);
            int c2 = getID(item.city2);
            if (ufs.find(c1) != ufs.find(c2)) {
                ans.add(item);
                ufs.union(c1, c2);
            }
        }
        if (ans.size() == n - 1) {
            return ans;
        } else {
            return new ArrayList<>();
        }
    }


    Map<String, Integer> name2ID = new HashMap<>();

    public int getID(String name) {
        if (name2ID.containsKey(name)) {
            return name2ID.get(name);
        } else {
            name2ID.put(name, n++);
            return n - 1;
        }
    }

    public class UFS {
        int[] f;          // father

        public UFS(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = -1;
            }
        }

        public void union(int a, int b) {
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

        public int find(int x) {
            if (f[x] < 0) {
                return x;
            }
            f[x] = find(f[x]);
            return f[x];
        }
    }
}
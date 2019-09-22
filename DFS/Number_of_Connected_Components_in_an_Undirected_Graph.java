Number_of_Connected_Components_in_an_Undirected_Graph.java
class Solution {
	public int countComp(int n, int[][] edges) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			if (!map.containsKey(u)) {
				map.put(u, new HashSet<>());
			}
			if (!map.containsKey(v)) {
				map.put(v, new HashSet<>());
			}
			map.get(u).add(v);
			map.get(v).add(u);
		}

		int count = 0;
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (visited.contains(i)) continue;
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			visited.add(i);
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				if (map.containsKey(curr)) {
					for (int num : map.get(curr)) {
						if (!visited.contains(num)) {
							queue.offer(num);
							visited.add(num);
						}
					}
				}
			}
			count++;
		}
		return count;
    }
}
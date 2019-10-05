movie_network.java
class Movie {
	int index;
	int rating;
	public Movie(int index, int rating) {
		this.index = index;
		this.rating = rating;
	}
}


class Solution {
	public int[] topK(int[] rating, int[][] G, int S, int K) {
		if (G == null || G.length == 0 || G[0] == null || G[0].length == 0 || rating == null || rating.length == 0 || rating.length != G.length) {
			return new int[0];
		}
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		queue.offer(S);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if (set.contains(curr)) continue;
			set.add(curr);
			for (int next : G[curr]) {
			    queue.offer(next);
			}
		}
		set.remove(S);
		PriorityQueue<Movie> pq = new PriorityQueue<Movie>(new Comparator<Movie>() {
			@Override
			public int compare(Movie a, Movie b) {
			    return a.rating - b.rating;
			}
		});
		for (int index : set) {
			pq.offer(new Movie(index, rating[index]));
			if (pq.size() > K) {
			    pq.poll();
			}
		}
		int[] res = new int[pq.size()];
		for (int i = 0; i < pq.size(); i++) {
			res[i] = pq.poll().index;
		}
		return res;
	}

}
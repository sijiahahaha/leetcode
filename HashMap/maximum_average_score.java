maximum_average_score.java
class Pair {
	double score;
	int count;
	public Pair(double score, int count) {
		this.score = score;
		this.count = count;
	}
}

class Solution {
	public double score(List<String> names, int[] grades) {
		if (grades == null || grades.length == 0 || names == null || names.size() != grades.length) {
			return 0;
		}

		Map<String, Pair> map = new HashMap<>();
		for (int i = 0; i < grades.length; i++) {
			String name = names.get(i);
			if (!map.containsKey(name)) map.put(name, new Pair(0, 0));
			Pair curr = map.get(name);
			curr.score += grades[i];
			curr.count += 1;
			map.put(name, curr);
		}
		double res = 0;
		for (String name : map.keySet()) {
			Pair curr = map.get(name);
			res = Math.max(res, curr.score / curr.count);
		}
		return res;
	}

}
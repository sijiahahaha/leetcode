aerial_movie.java
class Solution {
	public int[] aerial(int t, int[] dur) {
		if (dur == null || dur.length < 2) {
			return new int[0];
		}
		t = t - 30;
		Arrays.sort(dur);
		int[] res = new int[2];
		int max = Integer.MIN_VALUE;
		for (int i = dur.length - 1; i > 0; i--) {
			if (dur[i] > t) continue;
			int first = dur[i];
			int second = 0;
			int target = t - dur[i];
			int left = 0;
			int right = i - 1;
			while (left + 1 < right) {
				int mid = left + (right - left) / 2;
				if (dur[mid] <= target) {
					left = mid;
				} else {
					right = mid;
				}
			}
			if (dur[right] <= target) second = dur[right];
			else if (dur[left] <= target) second = dur[left];
			else second = dur[0];
			if (first + second > t || first + second < max) continue;
			if (max == first + second && res[1] > first) continue;
			max = first + second;
			res[0] = second;
			res[1] = first;
		}
		return res;
	}
}
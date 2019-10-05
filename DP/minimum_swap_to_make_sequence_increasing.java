minimum_swap_to_make_sequence_increasing.java
// int[] swap
// int[] noswap
// swap[0] = 1, noswap[0] = 0, else INF
// 1) A[i] > A[i - 1] && B[i] > B[i - 1]
//      swap[i] = min(swap[i], swap[i - 1] + 1)
//      noswap[i] = min(noswap[i], noswap[i - 1])
// 2) A[i] > B[i - 1] && B[i] > A[i - 1]
//      swap[i] = min(swap[i], noswap[i - 1] + 1)
//      noswap[i] = min(noswap[i], swap[i - 1])
// return min(swap[n], noswap[n])

class Solution {
	public int minSwap(int[] A, int[] B) {
		if (A == null || A.length == 0 || B == null || B.length == 0 || A.length != B.length) return 0;
		int n = A.length;
		int[] swap = new int[n];
		int[] noswap = new int[n];
		swap[0] = 1;
		noswap[0] = 0;
		for (int i = 1; i < n; i++) {
			swap[i] = Integer.MAX_VALUE;
			noswap[i] = Integer.MAX_VALUE;
			if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
				swap[i] = Math.min(swap[i], swap[i - 1] + 1);
				noswap[i] = Math.min(noswap[i], noswap[i - 1]);
			}
			if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
				swap[i] = Math.min(swap[i], noswap[i - 1] + 1);
				noswap[i] = Math.min(noswap[i], swap[i - 1]);
			}
		}
		return Math.min(swap[n - 1], noswap[n - 1]);

	}

}

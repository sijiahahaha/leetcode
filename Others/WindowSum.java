/**
比较 新进来的 和 刚出去的
newSum = preSum + (新进来的-刚出去的)

注意边界条件
**/

import java.util.ArrayList;
public List<Integer> GetSum(List<Integer> A, int k) {
	ArrayList<Integer> sums = new ArrayList<>();
	if (A == null || A.length == 0 || k <= 0) {
		return sums;
	}

	int sum = 0;
	for (int i = 0; i < k; i++) {
		sum += A.get(i); 
	}
	sums.add(sum);

	for (int i = k; i < A.length; i++) {
		sum = sum + A.get(i) - A.get(i-k);
		sums.add(sum);
	}
	return sums;
}
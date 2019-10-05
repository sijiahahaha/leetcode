Data_Stream_as_Disjoint_Intervals.java
class SummaryRanges {
    /**
     * @return: nothing
     */
    List<int[]> intervals;
    public SummaryRanges() {
        // 
        intervals = new ArrayList<int[]>();
    }

    /**
     * @param val: 
     * @return: nothing
     */
    public void addNum(int val) {
        // 
        addToInterval(val, 0, intervals.size() - 1);
    }
    private void addToInterval(int val , int left, int right) {
		if (left > right) {
			intervals.add(left, new int[]{val, val});
			return;
		}
		int mid = left + (right - left) / 2;
		int[] currInterval = intervals.get(mid);
		if (currInterval[0] - 1 == val) {
			//expend left and check left neighbor
			currInterval[0] = val;
			intervals.remove(mid);
			intervals.add(mid, currInterval);

			if (mid > 0) {
				int[] leftNeighbor = intervals.get(mid - 1);
				if (leftNeighbor[1] == currInterval[0] || leftNeighbor[1] + 1 == currInterval[0]) {
					int[] merged = new int[]{leftNeighbor[0], currInterval[1]};
					intervals.remove(mid);
					intervals.remove(mid - 1);
					intervals.add(mid - 1, merged);
				}
			}
		} else if (currInterval[1] + 1 == val) {
			// expend right and check right neighbor
			currInterval[1] = val;
			intervals.remove(mid);
			intervals.add(mid, currInterval);

			if (mid < intervals.size() - 1) {
				int[] rightNeighbor = intervals.get(mid + 1);
				if (rightNeighbor[0] == currInterval[1] || rightNeighbor[1] - 1 == currInterval[1]) {
					int[] merged = new int[]{currInterval[0], rightNeighbor[1]};
					intervals.remove(mid + 1);
					intervals.remove(mid);
					intervals.add(mid, merged);
				}
			}
		} else if (currInterval[0] > val) {
			addToInterval(val, left, mid - 1);
		} else if (currInterval[1] < val) {
			addToInterval(val, mid + 1, right);
		}
	}
    /**
     * @return: nothing
     */
    public int[][] getIntervals() {
        // 
        int[][] res = new int[intervals.size()][2];
		for (int i = 0; i < intervals.size(); i++) {
			res[i] = intervals.get(i);
		}
		return res;
    }
}
interval_search.java 
class Solution {
    public boolean interval(List<List<Integer>> intervals, int number) {
        if (intervals == null || intervals.size() == 0) return false;
        for (List<Integer> interval : intervals) {
            if (interval.get(0) <= number && interval.get(1) >= number) return true;
        }
        return false;
    }
}
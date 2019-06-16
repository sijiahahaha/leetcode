import java.util.TreeMap;
import java.util.NavigableMap;


public class Interval{
    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}



class Solution {
    public static int[] findRightinterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i)
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = entry != null ? entry.getValue() : -1;;
        }
        return result;
    }
}
~
~

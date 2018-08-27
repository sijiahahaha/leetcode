/**
|__|   |__|
  |__|   |__|

starts:
| |    |   |
ends:
   |  |   |  |
 
把start， end排序
对于每一个end，之前有多少个start就需要多少个room
当这个end结束，可以继续用这个room，所以下一个start不用room，end可以换到下一个。
if (starts[i] < ends[currEnd]) {
                result++;
            } else {
                currEnd++;
            }
**/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int result = 0;
        int currEnd = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[currEnd]) {
                result++;
            } else {
                currEnd++;
            }
        }
        return result;
    }
}
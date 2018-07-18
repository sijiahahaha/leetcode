/**  
Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

1.构造自定义Comparator的PriorityQueue，根据到原点距离，x，y排序，大的先出，最后剩小的
2.遍历Points，放入pq，size超过k之后，poll()
3.剩下的k个为最小，poll出来，先出的是相对大的，最后出的是最小的

**/



/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } 
 */
import java.util.PriorityQueue;
public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        Point o = origin;
        PriorityQueue<Point> pq = new PriorityQueue<Point> (k, new Comparator<Point> () {
           @Override
           public int compare(Point a, Point b) {
               int diff = getDistance(b, o) - getDistance(a, o);
               if (diff == 0) {
                   diff = b.x - a.x;
               }
               if (diff == 0) {
                   diff = b.y - a.y;
               }
               return diff;
           }
        });
        
        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int size = pq.size();
        Point[] result = new Point[size];
        while (!pq.isEmpty()) {
            result[--size] = pq.poll();
        }
        return result;
    }
    private int getDistance(Point a, Point b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }
}
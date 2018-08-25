/**
二分法：
int sqrt(x) :
    long start = 1, end = x, 
    long mid = start + (end - start)/ 2
    二分找last number^2 <= x

double sqrt(x):
    long start = 0, end = Math.max(1, x)
    while (end - start < 1e-6) {
        二分找last number^2 <= x
    }
**/

//int 
class Solution {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int)end;
        }
         return (int) start;
    }
}

//double
public class Solution {
    public double sqrt(double x) {
        double start = 0, end = Math.max(1, x); // note: end is not x
        double eps = 1e-10;
        while(start + eps < end) {
            double mid = (start + end) / 2;
            if(mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }
}
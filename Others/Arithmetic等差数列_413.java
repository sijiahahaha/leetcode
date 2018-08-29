/**  
A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
**/

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <3) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        
        for (int i = 2; i< A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }
        return sum;
    }
}



//sebsequence 如果是从数组中选数字出来构成等差
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Map<Integer, Integer>[] map = new Map[A.length];
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                if (Math.abs((long)A[i] - A[j]) > Integer.MAX_VALUE) {
                    continue;
                }
                int d = A[i] - A[j];
                int map_i_d = map[i].getOrDefault(d, 0);
                int map_j_d = map[j].getOrDefault(d, 0);
                map_i_d += map_j_d + 1;
                map[i].put(d, map_i_d);
                ans += map_j_d;
            }
        }
        return ans;
    }
}
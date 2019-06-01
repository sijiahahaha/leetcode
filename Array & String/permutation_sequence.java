  1 /**
  2 return kth permutation of n digit number
  3
  4 for n digit has (n)! permutation
  5
  6 **/
  7 import java.util.ArrayList;
  8 import java.util.List;
  9 class Solution {
 10     public String getPermutation(int n, int k) {
 11         if (n <= 0) {
 12             throw new IllegalArgumentException("Input error: invalid digit");
 13         }
 14         int[] factorial = new int[n + 1];
 15         factorial[0] = 1;
 16         for (int i = 1; i <= n; i++) {
 17             factorial[i] = factorial[i - 1] * i;
 18         }
 19         if (k > factorial[n]) {
 20             throw new IllegalArgumentException("Input error: invalid k");
 21         }
 22
 23         List<Integer> nums = new ArrayList<>();
 24         for (int i = 1; i <= n; i++) {
 25             nums.add(i);
 26         }
 27         k = k - 1;
 28         StringBuilder sb = new StringBuilder();
 29         for (int i = 1; i <= n; i++) {
 30             int index = k / factorial[n - i];
 31             sb.append(String.valueOf(nums.get(index)));
 32             nums.remove(index);
 33             k = k % factorial[n - i];
 34         }
 35
 36         return String.valueOf(sb);
 37
 38
 39     }
 40 }
~

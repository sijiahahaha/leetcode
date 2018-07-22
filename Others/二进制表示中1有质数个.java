/**
L, R will be integers L <= R in the range [1, 10^6].
说明最大的二进制有20位，所以prime的范围是「2, 3, 5, 7, 11, 13, 17, 19」
用Integer.bitCount(num)来得到二进制表示中1的个数
**/

public class Solution {
    /**
     * @param L: an integer
     * @param R: an integer
     * @return: the count of numbers in the range [L, R] having a prime number of set bits in their binary representation
     */
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int result = 0;
        for (int i = L; i <= R; i++) {
            int bit = Integer.bitCount(i);
            if (primes.contains(bit)){
                result++;
            }
        }
        return result;
    }
}
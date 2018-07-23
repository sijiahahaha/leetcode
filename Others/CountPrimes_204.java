/**
Count the number of prime numbers less than a non-negative number, n.

1. 边遍历边构造Primes数组
2. 对于新的数，如果可以由prime数整除，则不是prime
3. 如果循环到某个prime数，其平方已经大于num，但是还没有找到可以被整除的数，则num为prime，添加到Primes数组。
**/

public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        
        if (n == 3) {
            return 1;
        }
        
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        
        for (int i = 4; i <n; i++) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        
        return primes.size();
    }
    
    private boolean isPrime(int num, List<Integer> primes) {
        for (int prime : primes) {
            if (num % prime == 0) {
                return false;
            }
            if (prime * prime > num) {
                return true;
            }
        }
        return false;
    }
}
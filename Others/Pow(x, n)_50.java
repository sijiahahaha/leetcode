/**
实现Pow(x, n)  ->  x^n
用递归

2^2 = 2^1 * 2^1 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) = (1 * 1 * 2) * (1 * 1 * 2)
2^3 = 2^1 * 2^1 * 2 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) * 2 = (1 * 1 * 2) * (1 * 1 * 2) * 2

y = pow(x, n/2)
  n偶数： x^n = y * y 
  n奇数： x^n = y * y * x

要判断n正负，负数就取倒数
**/

class Solution {
    public double myPow(double x, int n) {
        if (n >= 0) {
            return helper(x, n);
        } else {
            return 1 / helper(x, n);
        }
    }
    
    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = helper(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}
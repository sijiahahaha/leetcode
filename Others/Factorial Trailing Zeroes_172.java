/**
求n！中结尾有多少个零
5！= 120， 有一个零

结尾0取决于 2*5 的个数， 而2肯定比5多， 所以取决于5的个数
对于阶乘，每乘一次5会阶乘
**/
class Solution {
    public int trailingZeroes(int n) {
        int result = n < 5 ? 0 : n/5 + trailingZeroes(n/5);
        return result;
    }
}
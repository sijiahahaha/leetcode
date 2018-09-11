/**
i-第i天结束     k-一共经过k次操作    0/1-还剩0或1支股票


Base cases:
T[-1][k][0] = 0, T[-1][k][1] = -Infinity
T[i][0][0] = 0, T[i][0][1] = -Infinity

Recurrence relations:
T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i] - fee)

**/

//一次交易的最大收益
//遍历，记录遇到的最小的，计算这一天卖的收益
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i : prices) {
            minPrice = Math.min(minPrice, i);
            maxProfit = Math.max(maxProfit, i - minPrice);
        }
        return maxProfit;
    }
}
 or 


public int maxProfit(int[] prices) {
    int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
        
    for (int price : prices) {
        T_i10 = Math.max(T_i10, T_i11 + price);
        T_i11 = Math.max(T_i11, -price);
    }
        
    return T_i10;
}

//可多次交易，最大收益
//就当作每天都在买和卖，只要当天有利润，就加起来
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}

or

public int maxProfit(int[] prices) {
    int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
    
    for (int price : prices) {
        int T_ik0_old = T_ik0;
        T_ik0 = Math.max(T_ik0, T_ik1 + price);
        T_ik1 = Math.max(T_ik1, T_ik0_old - price);
    }
    
    return T_ik0;
}




//最多两笔
/*
i-第i天结束     k-一共经过k次操作    0/1-还剩0或1支股票


Base cases:
T[i][0][0] = 0, T[i][0][1] = -Infinity
T[-1][k][0] = 0, T[-1][k][1] = -Infinity
T[i][2][0] = 0, T[i][2][1] = -Infinity

Recurrence relations:
T[i][2][0] = max(T[i - 1][2][0], T[i - 1][2][1] + prices[i])
T[i][2][1] = max(T[i - 1][2][1], T[i - 1][1][0] - prices[i])
T[i][1][0] = max(T[i - 1][1][0], T[i - 1][1][1] + prices[i])
T[i][1][1] = max(T[i - 1][1][1], T[i - 1][0][0] - prices[i])
*/
class Solution {
    public int maxProfit(int[] prices) {
        int T_i20 = 0, T_i21 = Integer.MIN_VALUE, T_i10 = 0, T_i11 = Integer.MIN_VALUE, T_i00 = 0;
        for (int i = 0; i < prices.length; i++) {
            T_i20 = Math.max(T_i20, T_i21 + prices[i]);
            T_i21 = Math.max(T_i21, T_i10 - prices[i]);
            T_i10 = Math.max(T_i10, T_i11 + prices[i]);
            T_i11 = Math.max(T_i11, T_i00 - prices[i]);
        }
        return Math.max(T_i20, T_i10);
    }
}


//买入时包含fee

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int t_ik0 = 0;
        int t_ik1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int t_ik0_temp = t_ik0;
            t_ik0 = Math.max(t_ik0, t_ik1 + prices[i]);
            t_ik1 = Math.max(t_ik1, t_ik0_temp - prices[i] - fee);
        }
        return t_ik0;
    }
}


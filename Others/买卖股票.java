/**

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
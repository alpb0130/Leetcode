/**
 * Created by alpb0130 on 1/28/16.
 * <p>
 * 122. Best Time to Buy and Sell Stock II
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as
 * you like (ie, buy one and sell one share of the stock multiple times). However, you may
 * not engage in multiple transactions at the same time (ie, you must sell the stock before
 * you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    // Finding constantly ascending order
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        int min_index = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                continue;
            profit += prices[i - 1] - prices[min_index];
            min_index = i;
        }
        profit += prices[prices.length - 1] - prices[min_index];
        return profit;
    }

    // Equivalent method.
    // Once you can get profit, make the transaction.
    // You may be involve in two transactions in the same day.
    // But the result is good.
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}

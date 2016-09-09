/**
 * Created by alpb0130 on 1/28/16.
 * <p>
 * 121. Best Time to Buy and Sell Stock
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one
 * share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
    // DP. Time complexity: O(n). Space complexity: O(1);
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if (l <= 1) return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < l; i++) {
            // 这两句可以交换
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}

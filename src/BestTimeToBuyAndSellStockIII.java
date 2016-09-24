/**
 * Created by alpb0130 on 2/25/16.
 * <p>
 * 123. Best Time to Buy and Sell Stock III
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {
    // DP. Time complexity: O(n). Space complexity:O(n)
    // Divide the process into two parts. Record the maximum profit of those two parts.
    // Find the best solution by traverse two array.
    // The third loop seems to be wrong because it would allow two transactions in one day
    // But it's actually good.
    // Case 1: The actual solution is that buying and selling on the same day. But in fact,
    // it can be regarded as one transaction.
    // Case 2: The actual solution is that two transaction is not on the same day. That is good/
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        int l = prices.length;
        int[] profit1 = new int[l];
        int[] profit2 = new int[l];
        int min_price = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < l; i++) {
            min_price = Math.min(prices[i], min_price);
            profit1[i] = Math.max(max, prices[i] - min_price);
            max = profit1[i];
        }
        int max_price = 0;
        max = 0;
        for (int i = l - 1; i >= 0; i--) {
            max_price = Math.max(prices[i], max_price);
            profit2[i] = Math.max(max, max_price - prices[i]);
            max = profit2[i];
        }
        int ret = 0;
        for (int i = 0; i < l; i++) {
            ret = Math.max(profit1[i] + profit2[i], ret);
        }
        return ret;
    }

    // Time complexity: O(n). Space complexity:O(1)
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int price : prices) {
            if (firstBuy < -price) firstBuy = -price;
            if (firstSell < firstBuy + price) firstSell = firstBuy + price;
            if (secondBuy < firstSell - price) secondBuy = firstSell - price;
            if (secondSell < secondBuy + price) secondSell = secondBuy + price;
        }
        return secondSell;
    }
}

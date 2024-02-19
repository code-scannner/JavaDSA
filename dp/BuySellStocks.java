package dp;

import java.util.*;

public class BuySellStocks {
    public static int buySellStocksII(int prices[]) {
        int n = prices.length;
        int buy[] = new int[n];
        int sell[] = new int[n];
        sell[n - 1] = prices[n - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            buy[i] = Math.max(buy[i + 1], -prices[i] + sell[i + 1]);
            sell[i] = Math.max(sell[i + 1], prices[i] + buy[i + 1]);
        }

        return buy[0];

    }

    public static int buySellStocksIII(int prices[]) {
        int n = prices.length;
        int buyfirst[] = new int[n], sellFirst[] = new int[n], buySecond[] = new int[n], sellSecond[] = new int[n];
        sellSecond[n - 1] = prices[n - 1];
        sellFirst[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            buyfirst[i] = Math.max(buyfirst[i + 1], -prices[i] + sellFirst[i + 1]);
            sellFirst[i] = Math.max(sellFirst[i + 1], prices[i] + buySecond[i + 1]);
            buySecond[i] = Math.max(buySecond[i + 1], -prices[i] + sellSecond[i + 1]);
            sellSecond[i] = Math.max(sellSecond[i + 1], prices[i]);
        }
        return buyfirst[0];
    }

    public static int memoIV(int dp[][][], int prices[], int i, int buy, int k) {
        if (i == prices.length)
            return 0;
        if (k == 0)
            return 0;
        if (dp[i][buy][k] != -1)
            return dp[i][buy][k];
        if (buy == 1) {
            dp[i][buy][k] = Math.max(-prices[i] + memoIV(dp, prices, i + 1, 1 - buy, k),
                    memoIV(dp, prices, i + 1, buy, k));
        } else {
            dp[i][buy][k] = Math.max(prices[i] + memoIV(dp, prices, i + 1, 1 - buy, k - 1),
                    memoIV(dp, prices, i + 1, buy, k));
        }
        return dp[i][buy][k];
    }

    public static int buySellStocksIV(int prices[], int k) {
        int dp[][][] = new int[prices.length][2][k + 1];
        for (int[][] matrix : dp)
            for (int[] arr : matrix)
                Arrays.fill(arr, -1);
        return memoIV(dp, prices, 0, 1, k);
    }

    public static int buySellStocksWithCoolDown(int prices[]) {
        // cooldown should be of one day min if you are selling
        int n = prices.length;
        int buy[] = new int[n];
        int sell[] = new int[n];
        sell[n - 1] = prices[n - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            buy[i] = Math.max(buy[i + 1], -prices[i] + sell[i + 1]);
            sell[i] = Math.max(sell[i + 1], prices[i] + (i + 2 < prices.length ? buy[i + 2] : 0));
        }

        return buy[0];
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(buySellStocksII(prices));
        int pricesIII[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(buySellStocksIII(pricesIII));
        int pricesIV[] = { 3, 2, 6, 5, 0, 3 };
        System.out.println(buySellStocksIV(pricesIV, 2));
        int pricesCoolDown[] = { 1, 2, 3, 0, 2 };
        System.out.println(buySellStocksWithCoolDown(pricesCoolDown));
    }
}

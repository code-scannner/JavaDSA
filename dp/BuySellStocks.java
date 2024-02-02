package dp;

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

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(buySellStocksII(prices));

    }
}

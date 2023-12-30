package dp;

public class MinimumCoins {
    // space optimized O(target) space, time O(coins*target) tabulation
    public static int minimumCoins(int coins[], int target) {
        int dp[] = new int[target + 1];

        // base case for coins[0]
        for (int j = 0; j <= target; j++) {
            dp[j] = j % coins[0] == 0 ? j / coins[0] : (int) 1e9;
        }

        for (int i = 1; i < coins.length; i++) {
            int curr[] = new int[target + 1];
            for (int sum = 0; sum <= target; sum++) {
                int keep = Integer.MAX_VALUE;
                if (sum - coins[i] >= 0) {
                    keep = 1 + curr[sum - coins[i]];
                }
                int discard = dp[sum];

                curr[sum] = Math.min(keep, discard);
            }
            dp = curr;
        }

        return dp[target] >= (int) 1e9 ? -1 : dp[target];
    }

    public static int countCoins(int coins[], int target, int i) {
        // recursive soln
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;
        if (i == 0) {
            return (target % coins[0] == 0) ? 1 : 0;
        }

        int take = countCoins(coins, target - coins[i], i);
        int nottake = countCoins(coins, target, i - 1);

        return take + nottake;
    }

    public static int countCoins(int coins[], int target) {

        // tabulation
        int dp[] = new int[target + 1];

        // base case for coins[0]
        for (int j = 0; j <= target; j++) {
            dp[j] = j % coins[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < coins.length; i++) {
            int curr[] = new int[target + 1];
            for (int j = 0; j <= target; j++) {
                int keep = j - coins[i] >= 0 ? curr[j - coins[i]] : 0;
                int discard = dp[j];
                curr[j] = keep + discard;
            }
            dp = curr;
        }

        return dp[target];

    }

    public static void main(String[] args) {
        int coins[] = { 1, 6, 5, 9 };
        int target = 11;

        System.out.println(minimumCoins(coins, target));

        System.out.println(countCoins(coins, target, coins.length - 1));
        System.out.println(countCoins(coins, target));

    }
}

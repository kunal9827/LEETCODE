class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < i; j++) {
                int profit = prices[i] - prices[j];
                if (j > 0) {
                    profit += dp[j - 2 < 0 ? 0 : j - 2];
                }
                dp[i] = Math.max(dp[i], profit);
            }
        }
        return dp[n - 1];
    }
}
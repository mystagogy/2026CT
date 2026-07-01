class Solution {
    public int solution(int[] money) {
        int n = money.length;

        return Math.max(
            rob(money, 0, n - 2),
            rob(money, 1, n - 1)
        );
    }

    static int rob(int[] money, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];

        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(
                dp[i - 1],
                dp[i - 2] + money[start + i]
            );
        }

        return dp[len - 1];
    }
}
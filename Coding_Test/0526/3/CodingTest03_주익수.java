class Solution {
    public int solution(int N) {
        int[] dp = new int[11];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N-1];
    }

}
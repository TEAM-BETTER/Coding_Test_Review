/*
* dp[i][j] = 깊이 i이고 j번째 땅을 팠을 때 에너지의 최소 값
* dp[i][j] = Min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])  0과 열의 끝은 2개만 비교
* */
class Solution {
    public int solution(int depth, int n, int[][] blocks) {
        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[blocks.length][blocks[0].length];

        for (int i = 0; i < blocks[0].length; i++) {
            dp[0][i] = blocks[0][i];
        }

        for (int i = 1; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = blocks[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }else if (j == blocks[i].length - 1) {
                    dp[i][j] = blocks[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                }else {
                    dp[i][j] = blocks[i][j];
                    int temp = dp[i-1][j-1];
                    temp = Math.min(temp, dp[i-1][j]);
                    temp = Math.min(temp, dp[i-1][j+1]);
                    dp[i][j] += temp;
                }
            }
        }

        return dp[depth][n];
    }
}
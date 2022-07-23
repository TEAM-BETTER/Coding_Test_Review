class Solution {

    public int solution(int depth, int n, int[][] blocks) {

             int[][] dp = new int[2][blocks[0].length];


        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = blocks[0][i];
        }


        if (depth == 0) {
            return blocks[0][n];
        }


        for (int i = 1; i <= depth; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                if (j-1 < 0) {
                    dp[1][j] = Math.min(dp[0][j], dp[0][j+1]) + blocks[i][j];
                } else if (j+1 > dp[0].length - 1) {
                    dp[1][j] = Math.min(dp[0][j], dp[0][j-1]) + blocks[i][j];
                } else {
                    dp[1][j] = Math.min(dp[0][j], Math.min(dp[0][j+1], dp[0][j-1])) + blocks[i][j];
                }
            }
            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            dp[0][2] = dp[1][2];
            dp[0][3] = dp[1][3];
        }
        return dp[1][n];
    }


    public static void main(String[] args) {
        int depth = 3;
        int n = 0;
        int[][] blocks = {{1,2,4,1}, {1,6,4,9}, {5,6,9,4}, {55,14,21,14}};
        System.out.println(new Solution().solution(depth, n, blocks));
    }
}

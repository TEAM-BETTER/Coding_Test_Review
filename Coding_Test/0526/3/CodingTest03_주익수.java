class Solution {
    public int solution(int N) {
        int[] dp = new int[11]; //dynamicProgramming으로 판단하였음

        dp[0] = 1; //첫번째는 1
        dp[1] = 2; //두번째는 2

        for (int i = 2; i <= 10; i++) { //다음과 같은 점화식사용
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N-1];
    }

}
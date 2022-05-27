class Solution {
    public int solution(int N) {
        int[] dp = new int[11]; //D[i] 는 세로가 i인 사각형의 개수
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2]; // 점화식
        }
        return dp[N];
    }
}

// 비슷한 문제로  2 x n 타일링 문제가 있는데 그림 설명이 잘 나와있습니다.
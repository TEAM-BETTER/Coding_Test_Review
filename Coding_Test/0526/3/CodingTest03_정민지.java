import java.util.*;
class Solution {
  /*
    DP 문제 기본, 타일링 문제인 것 같음
   */
    public int solution(int N) {
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]);
        }
        return dp[N];
    }
}

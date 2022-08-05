package codiingTest.codingTest11.p4;

import java.util.Arrays;

// DP 문제 생각을 좀 오래하다가 풀었습니다.
// 배낭 문제와 비슷한 느낌이였습니다.
public class Solution {
    public static int solution(int money, int[] chips) {
        int INF = 100;
        int len = chips.length;
        Arrays.sort(chips);             // chips 정렬 // 큰 값부터 사용하기 위해

        int[] dp = new int[money + 1];  // 돈이 i 원일때 사용하는 동전의 갯수 기록하기 위한 DP // ex) DP[100] -> 100 원일 때 사용하는 최소의 동전 갯수수
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = chips[0]; i <= money; i++) {       // i 원부터 money 원 까지 dp 없데이트
            for (int j = len - 1; j >= 0; j--) {        // 동전 i 를 가지고 j 원 부터 0원 까지 DP 업데이트
                // 동전이 j 원보다 작고 dp[i - chips[j]] 와 dp[i] 를 비교해서 dp 에 업데이트
                if (chips[j] <= i && dp[i - chips[j]] != INF && dp[i - chips[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - chips[j]] + 1;
                }
            }
        }

        return dp[money];
    }

    public static void main(String[] args) {
        int m = 3000;
        int[] c = new int[]{1100, 500, 200, 150, 25};
        System.out.println(solution(m, c));
    }
}


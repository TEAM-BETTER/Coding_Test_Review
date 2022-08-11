
/**
 * 유일하게 풀고 넘어간 문제네요
 * 처음 그리디로 풀었다가 주어지는 코인의관계 가 배수가 아니기 떄문에 
 * dp 로 접근했습니다. 배낭에 주워담는 것과 비슷한 느낌으로 풀었습니다.
 * 현재 주어진 코인으로 배열을 작은값으로 업데이트 해줍니다.
*/
import java.util.*;

class Solution4 {
    public int solution(int money, int[] chips) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, 1 << 30); // init 채워주기 배열
        dp[0] = 0;
        for (int chip : chips) {
            for (int i = chip; i <= money; i++) {
                int tmp = dp[i - chip] + 1; // i-chip 을 하기 때문에 지난번 코인의 값을 가중치로 계속 업데이트 가능
                if (dp[i] > tmp)
                    dp[i] = tmp; // 작은값으로 업데이트
            }
        }
        return dp[money]; // 바ㅣㄴ환
    }
}

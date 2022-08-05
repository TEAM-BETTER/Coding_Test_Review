/*
  저는 이 문제가 배수가 아니니까
  그리디가 안되는 거스름돈 문제구나 했습니당.
  그럴 경우 dp를 쓰면 되지! 하는 생각을 했고요.

  저희는 지금 최소 칩의 개수를 구해야 하니까 가장 작은
  단위로 나눈 값을 채우면 되는데 단위에서 나올 수 있는
  가장 작은 값은 1로 생각하여 money 값으로 dp 배열을 채워줍니다.
  (1400원이면 칩 단위 1로 했을 때 최대 1400개가 나옴, 1400으로 채워주는 식)

  현재 교환한 칩의 금액만큼 빼고 이전에 교환한 칩의 최소 개수 + 1
  == 교환해 줄 칩이 얼마나 될지입니다.
  Math.min(dp[j], dp[j - chips[i]] + 1)

  얘는 20점입니다!
 */
import java.util.*;
class Solution {
    public int solution(int money, int[] chips) {
        int answer = 0;
        int[] dp = new int[money + 1];
        Arrays.fill(dp, money);
        // 0원을 교환하는 방법은 0개입니다.
        dp[0] = 0;

        for (int i = 0; i < chips.length; i++){
            for (int j = chips[i]; j <= money; j++){
                dp[j] = Math.min(dp[j], dp[j - chips[i]] + 1);
            }
        }
        return dp[money];
    }
}

import java.util.*;
class Solution {
  /*
    이 문제를 푸는데 꽤 오랜 시간이 걸렸던 것 같습니다. ㅠㅠ
    정말 오래 삽질을 했던 것 같아요.
    꽤 오래전에 비슷한 문제를 풀어봤던 것 같은데 정확히 어떤 문제였는지 기억이 나지는 않네요.
    근데 사실 이 문제를 한참 풀다가 이미 1시간 넘게 흘러갔더라고요.
    거기서부터 저는 어.. 이게... easy라고..? 나만 너무 어렵나..?
    이번에 한 문제도 못 풀면 어떡하지? 하면서 멘탈이 와르르맨션

    아무튼 풀이에 대해서는 아래 주석으로 함께 하겠습니다.
  */
    public int solution(int[] start, int[] end, int[] price) {
        int[][] reserv = new int[price.length][3];
        /*
            reserv[i][0] = 시작 시간
            reserv[i][1] = 종료 시간
            reserv[i][2] = 비용

            일단 시작 시간, 종료 시간, 비용 등을 배열 하나로 묶자고 생각해서
            reserv라는 배열을 선언하여 start[] end[] price[]를 묶었습니다.
            클래스를 사용하고 싶었는데 그러기엔 머리가 조금 다급하고 복잡한 상태라
            습관적으로 또 배열을 사용했습니다. ㅠㅠ
        */
        for (int i = 0; i < price.length; i++) {
            reserv[i][0] = start[i];
            reserv[i][1] = end[i];
            reserv[i][2] = price[i];
        }

        // 하나로 묶은 reserv 배열을 종료 시간 기준으로 정렬힙니다.
        Arrays.sort(reserv, ((x, y) -> x[1] - y[1]));
        // dp가 담길 배열을 reserv의 크기만큼 선언해줍니다.
        int[] dp = new int[reserv.length];
        // 0번째 작업 기준에서 가장 큰 이익은 0번째 주어진 비용입니다!
        dp[0] = reserv[0][2];
        // 1부터 reserv의 길이만큼 반복문을 도는데 상향식으로 dp 배열을 채울 거에요.
        for (int i = 1; i < reserv.length; i++) {
          // 우선 현재 reserv i번째의 상담 비용을 가져옵니다.
            int tmp = reserv[i][2];
            // checked 함수에서 현재 상담 시간의 시작 시간보다 종료 시간이 작거나 같은
            // 마지막 상담의 idx를 데려왔습니다.
            int idx = checked(reserv, i);
            /*
              idx가 -1이 아니라면 (현재 i번째 상담 시작 시간보다 작거나 같은 상담 종료 idx를 찾지 못했을 경우)
              현재 상담 비용 + dp[idx]에 누적된 비용을 가져옵니다.
             */
            if (idx != -1) tmp += dp[idx];
            /*
              tmp와 dp[i - 1]을 비교하여 더 큰 값을 dp[i]에 삽입합니다.
              => 현재 상담을 쓰거나 쓰지 않습니다.
              (쓴다면 현재인 i번째 상담 비용 +한 값, 그렇지 않다면 이전 값을 데려와요.)
            */
            dp[i] = Math.max(tmp, dp[i - 1]);
        }
        // dp 배열의 마지막 인덱스가 최대 상담 비용입니다.
        return dp[reserv.length - 1];
    }
    /**
     * [int checked]
     * @param  reserv [시작 / 종료 / 비용 정보가 담긴 이차원 배열]
     * @param  n      [위의 main 함수 for문에서 현재 돌고 있는 i값]
     * @return        [종료 시간이 현재 i번째 상담 시작 시간보다 작거나 같은 마지막 상담 종료 idx를 찾아봅니다!]
     */
    public static int checked(int[][] reserv, int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (reserv[i][1] <= reserv[n][0]) return i;
        }
        // 찾지 못하면 음수를 반환합니다.
        return -1;
    }
}

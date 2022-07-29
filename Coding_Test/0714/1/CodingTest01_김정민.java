import java.util.Arrays;

/*
* 먼저 이 문제를 봤을 때 백준에 있는 퇴사 문제랑 비슷하다는 생각을 했습니다.
* https://www.acmicpc.net/problem/15486
*
* 다만 퇴사 문제랑 다른 점은 이 문제는 start 시간이 섞여서 들어 온다는 점이 다른데,
* 그래서 start가 작은순으로 정렬을 하고 풀이를 진행 하였습니다.
* dp[i] = i번 째 강연을 진행 했을 때 최대 값으로 테이블을 정의하고 풀이를 진행 하였습니다.
* */
public class Solution {
    public int solution(int[] start, int[] end, int[] price) {
        int answer = 0;
        Info[] infos = new Info[start.length];

        for (int i = 0; i < start.length; i++) {
            infos[i] = new Info(start[i], end[i], price[i]);
        }

        Arrays.sort(infos);

        int[] dp = new int[start.length];
        // 0번째는 무조건 강의를 진행해야 최대 입니다.
        dp[0] = infos[0].price;

        for (int i = 1; i < infos.length; i++) {
            dp[i] = infos[i].price; // 테이블 정의상 dp[i]는 i번째 강의를 무조건 포함해야 합니다.

            int temp = 0; // 이전 dp테이블 중 최대 값을 찾기 위한 임시 변수 입니다.
            for (int j = 0; j < i; j++) {
                if (infos[j].end <= infos[i].start) { // 이전 강의의 끝나는시간이 현재강의의 시작보다 작거나 같아야 강의를 같이 진행 할 수 있습니다.
                    temp = Math.max(temp, dp[j]);
                }
            }

            dp[i] += temp; // 최대값을 dp[i]에 더해 줍니다.
        }

        // dp 테이블중 최대 값을 찾습니다.
        for (int i = 0; i < infos.length; i++) {
            answer = Math.max(dp[i], answer);
        }

        return answer;
    }

    class Info implements Comparable<Info>{
        int start;
        int end;
        int price;

        public Info(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Info o) {
            return this.start - o.start;
        }
    }
}
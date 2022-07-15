
/**
 * 정확성 3개 만 통과한 코드입니다. 여기서 1시간 이상 보낸거 같네요 .. ㅜ
 * 처음에 그리디 강사님 과 풀었던 시간 분배 문제가 새각나서 PriorityQueue 를 이용해 문제접근할 생각을 가졌습니다.
 * 현재시간 기준으로 앞에 서 종료된 시간이 있다면 값을 계산후 다음 으로 넘겨주고 넘겨주는 dp를 생각했습니다.
 * 예를들어 1~3,3,6 4,6 이 있다면 6의 종료 시간을 계산하기위해서는 
 * 1~3 + 4~6;
 * 1~3 + 3~6; 이렇게 계산해주기 위해서 위와같이 로직을 정했습니다.
 * 종료시간이 최대 10000 이기 때문에 10001 로 지정해줍니다.
 */
import java.util.*;

class Solution {
    public int solution(int[] start, int[] end, int[] price) {
        int dp[] = new int[10001];
        int last = 0; // 가장 마지막 시간을 트래킹하기 위해 선정
        int first = 0; // 굳이 시간 1 부터 탐색할 필요가 없어 시작시간 업데이트를 위해 지정
        PriorityQueue<Schedlue> q = new PriorityQueue<>();
        for (int i = 0; i < start.length; i++) {
            q.add(new Schedlue(start[i], end[i], price[i]));
        }
        while (!q.isEmpty()) {
            Schedlue cur = q.poll();
            last = cur.end;
            for (int i = first; i <= cur.start; i++) {
                // 지난번 으로 부터 업데이트 된 마지막 시간으로 부터 dp max 채워줍니다.
                dp[last] = Math.max(dp[last], dp[i] + cur.price);
            }
            first = cur.start;
        }

        return dp[last]; // 마지막 시간 반환 해주는데, 어디가 오류가 났을까요 쥬륵...
    }

    class Schedlue implements Comparable<Schedlue> {
        int start;
        int end;
        int price;

        Schedlue(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Schedlue o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
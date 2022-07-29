import java.util.*;

/**
 * 다익스트라 기본구현 으로 작성했습니다.
 * 다익스트라 강의 에서 강사님 코드와 매우 유사합니다.
 * 블로그 에 예전에 작성해 놓은게 있는데 참고하실분은 참고해주세용
 * https://guiwoo.tistory.com/16
 */

class Solution {
    List<ArrayList<int[]>> list = new ArrayList<>(); // 간선 담을 list

    public void init(int n, int[][] edge) { // 간선 업데이트
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(new int[] { edge[i][1], edge[i][2] });
        }
    }

    public int solution(int N, int[][] edge) {
        init(N, edge);
        int[] dp = new int[N]; // 거리 기록할 dp
        boolean[] visit = new boolean[N]; // 방문여부 체크
        Arrays.fill(dp, 1 << 30);
        dp[0] = 0; // 항상 0 에서 출발
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        q.offer(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visit[cur[0]])
                continue;
            visit[cur[0]] = true;
            for (int i = 0; i < list.get(cur[0]).size(); i++) {
                int[] next = list.get(cur[0]).get(i);
                if (visit[next[0]])
                    continue;
                if (dp[next[0]] > cur[1] + next[1]) {
                    dp[next[0]] = cur[1] + next[1];
                    q.offer(new int[] { next[0], dp[next[0]] });
                }
            }
        }
        int idx = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[idx] < dp[i]) {
                idx = i;
            }
        }

        return idx;
    }
}
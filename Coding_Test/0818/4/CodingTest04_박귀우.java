
/**
 * 16점 짜리 코드입니다...
 * 그냥 그래프 초기화 하고 bfs 돌렸습니다.
 */

import java.util.*;

class Solution {
    List<ArrayList<int[]>> list = new ArrayList<>();

    public void init(int n, int[][] edge) {
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(new int[] { edge[i][1], 1 });
        }
    }

    public int solution(int N, int[][] edge) {
        if (N == 1)
            return 1;
        init(N, edge);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 1, 0 });
        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N) {
                answer = cur[1];
                break;
            }
            for (int i = 0; i < list.get(cur[0]).size(); i++) {
                int[] next = list.get(cur[0]).get(i);
                q.add(new int[] { next[0], next[1] + cur[1] });
            }
        }
        // 그리디하게 10이 가장큰 이동의 경우의 수여서 아래와같이 작성
        int reach = answer;
        int cnt = 0;
        while (reach > 0) {
            if (reach >= 10) {
                reach -= 10;
                cnt++;
            } else {
                cnt++;
                break;
            }
        }
        return cnt;
    }
}
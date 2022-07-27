// 통과못한 0점 코드입니다.
// 바이러스 감염후 for loop 을 돌려 사람별로 확인하려 했으나 로직이 잘못 되었나봐요.. ㅎㅎ

import java.util.*;

class Solution {
    boolean checker = false;
    ArrayList<ArrayList<int[]>> virus = new ArrayList<>(); // 바이러스 그래프

    private void init(int[][] graph, int N) {
        for (int i = 0; i < N; i++) {
            virus.add(new ArrayList<>());
        }
        int cnt = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    cnt++;
                    virus.get(i).add(new int[] { i, j });
                    virus.get(j).add(new int[] { j, i });
                }
            }
        }
        if (cnt == N * N)
            checker = true; // 만약 1 이 사람수*사람수 만큼의 횟수가 카운트 된다면 한명만 걸려도 모두 걸리기때문에 먼저 계산
    }

    public int solution(int N, int[][] graph, int[] infected) {
        init(graph, N);
        if (checker)
            return 0; // 이 부분이 infected 길이가 0 이 아니란 조건을 추가해 주어야 할듯하네요.
        int[] dp = new int[N];
        for (int i = 0; i < infected.length; i++) { // 감염 된 사람에 따른 반복
            int answer = 0;
            Queue<int[]> q = new LinkedList<>();
            boolean visit[] = new boolean[N];
            q.add(new int[] { i, i });

            while (!q.isEmpty()) { // 와 여기 ! 를 추가를 안했네요 제가 ...
                int[] cur = q.poll();
                if (visit[cur[1]])
                    continue;
                visit[cur[1]] = true;
                answer++;
                if (answer == N)
                    break;
                for (int j = 0; j < virus.get(cur[1]).size(); j++) { // 바이러스 그래프 사이즈만큼 받아와서 업데이트
                    int[] next = virus.get(cur[1]).get(j);
                    if (visit[next[1]])
                        continue;
                    else
                        q.offer(new int[] { next[1], next[1] });
                }
            }
            dp[infected[i]] = answer; // dp 배열에 업데이트 ,
        }
        int max = 0;
        int idx = 0;
        for (int i = 0; i < dp.length; i++) { // dp 배열을확인해 최대값의 인덱스를 반환하는건데.. 쥬륵
            if (dp[i] > max) {
                idx = i;
                max = dp[i];
            }
        }
        return idx;
    }
}
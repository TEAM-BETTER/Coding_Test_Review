import java.util.*;
// 12점 짜리 코드입니다.
// 최소값을 dp 에 변경해주면서 계산을 했는데;
// 시작점을 선정해주는데 있어 각각 의 경우의 수마다 값이 달라서 모든 시작점을 확인해주는데 
// 이부분에서 시간초과 나서 8점 이까인거 같습니다.

class Solution {
    ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

    private void init(int n, int[][] relations) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < relations.length; i++) {
            int[] cur = relations[i];
            graph.get(cur[0]).add(new int[] { cur[1], cur[2] }); // 앞뒤로 연결
            graph.get(cur[1]).add(new int[] { cur[0], cur[2] });
        }
    }

    public int solution(int N, int[][] relations) {
        init(N, relations);
        int answer = 1 << 30; // answer 값 초기화
        for (int i = 0; i < N; i++) {
            int[] dp = mst(N, i); // 배열을 받아와서 최소값 업데이트
            answer = Math.min(answer, Arrays.stream(dp).sum());
        }
        return answer;
    }

    public int[] mst(int N, int start) {
        int[] dp = new int[N];
        Arrays.fill(dp, 30); // 30이상이 될수 없기떄문에 초기화
        boolean[] visit = new boolean[N];
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        q.add(new int[] { start, 0 }); // q에넣어주면서 업데이트 합니다.
        while (!q.isEmpty()) {
            int[] cur = q.poll(); // 뽑아서 계산
            if (visit[cur[0]])
                continue;
            visit[cur[0]] = true;
            for (int i = 0; i < graph.get(cur[0]).size(); i++) {
                int[] next = graph.get(cur[0]).get(i);
                if (visit[next[0]])
                    continue;
                if (dp[next[0]] > next[1]) {
                    dp[next[0]] = next[1]; // 디피에 추가값이 아닌 업데이트된 값 적용
                    q.add(new int[] { next[0], dp[next[0]] });
                }
            }
        }
        return dp;
    }
}
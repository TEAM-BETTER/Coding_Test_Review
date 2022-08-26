package CodingTest14;

import java.util.*;

/**
 * 정확성 : 8 / 효율성 : 6
 *
 * 1. State : idx: 노드
 *            repeat: 턴수를 증가시키지 않고 한번 더 던질 수 있는지 여부
 *            cnt: 턴 수
 *
 * 2. Map의 key 값으로 1부터 N까지 셋팅
 *         value값으로 edge[0] 을 키 값에 맞춰 edge[1]을 List로 넣어줌
 *
 * 3. ArrayDeque에 초기값 idx: 1, repeat : false, cnt: 0을 넣고 N까지 턴 횟수 체크
 *
 * 4. visited 배열은 최소 cnt값을 체크하기 위해 초기값은 Integer.MAX_VALUE 으로 채움
 *
 * 5. 도개걸 이 나온 경우 다음으로 이동 했을 경우 q에 데이터 저장
 *    윷 모가 나온 경우 다음으로 이동 했을 경우 repeat 값 체크해서 q에 데이터 저장
 *
 * 6. 만약 지름길이 나온 경우라면, 지름길을 idx 값으로 q에 데이터 저장
 *
 * 7. idx가 N이 나오면 cnt값 리턴해줌
 *
 */

public class CodingTest4_김우진 {

    static class State {
        int idx;

        boolean repeat;

        int cnt;

        public State(int idx, boolean repeat, int cnt) {
            this.idx = idx;
            this.repeat = repeat;
            this.cnt = cnt;
        }
    }

    static Map<Integer, List<Integer>> shortCuts = new HashMap<>();

    static int answer;

    public static int solution(int N, int[][] edges) {
        answer = (N + 10) / 10;

        for (int i = 1; i <= N; i++) {
            shortCuts.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            shortCuts.get(edge[0]).add(edge[1]);
        }

        Queue<State> q = new ArrayDeque<>();
        q.add(new State(1, false, 0));

        int[] visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[1] = 0;

        while (!q.isEmpty()) {
            State state = q.poll();
            int idx = state.idx;
            boolean repeat = state.repeat;
            int cnt = state.cnt;

            // 도착
            if (idx == N) {
                return cnt;
            }

            // 윷, 모
            for (int k = 4; k <= 5; k++) {
                if (idx + k > N
                        || visited[idx + k] <= (repeat ? cnt : cnt + 1)) {
                    continue;
                }

                visited[idx + k] = repeat ? cnt : cnt + 1;
                q.add(new State(idx + k, !repeat, repeat ? cnt : cnt + 1));
            }

            // 도, 개, 걸
            for (int k = 1; k <= 3; k++) {
                if (idx + k > N
                        || visited[idx + k] <= (repeat ? cnt : cnt + 1)) {
                    continue;
                }

                visited[idx + k] = repeat ? cnt : cnt + 1;
                q.add(new State(idx + k, false, repeat ? cnt : cnt + 1));
            }

            // 지름길
            for (int next : shortCuts.get(idx)) {
                q.add(new State(next, repeat, cnt));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 100;
        int[][] edges = {{12, 40}, {18, 53}, {59, 89}};

        System.out.println(solution(N, edges));
    }
}
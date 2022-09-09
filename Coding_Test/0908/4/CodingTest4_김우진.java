package CodingTest16;

import java.util.PriorityQueue;

public class CodingTest4_김우진 {

    /**
     * State : 좌표 y, x, effort
     *      -> effort 기준으로 오름차순 정렬
     * N, M : 주어진 heights 배열의 길이
     * dy, dx : 상하좌우 이동 가능한 커맨드
     * visited : 해당 지역 방문했는지, 확인용 boolean
     * isOutOfBounds : heights 배열의 범위 벗어났는지 체크
     *
     * height와 같은 크기의 diff 배열을 만들어서 Integer.MAX_VALUE로 전부 채워서 초기셋팅
     *      -> diff : effort 값 확인용 배열
     *
     * 출발지인 diff[0][0]의 값 0으로 초기 셋팅
     *
     * PriorityQueue에 초기값 (x: 0, y: 0, effort: 0)으로 셋팅
     *
     * pq에서 꺼낸 값 기준 상하좌우 확인
     *      -> 상하좌우 움직였을때 범위 벗어나면 패스
     *      -> 이미 방문했던 지역이면 패스
     *      -> 최대 노력치는 Math.max(현재 좌표의 높이값 - 다음 이동 좌표의 높이값)의 절대값, 현재 노력치)
     *      -> 만약 다음 좌표로 이동했을때 노력치가 현재 노력치보다 크면 diff[y][x]값  diff[nextY][nextX]로 교체
     *      pq에 다음 이동 가능 지역 (nextY, nextX, diff[nextY][nextX]) 넣어줌
     * pq값이 없을 때 까지 반복, 목적지 도달하면 해당 좌표의 effort 값 리턴
     *
     */

    static class State implements Comparable<State> {

        int y;

        int x;

        int effort;

        public State(int y, int x, int effort) {
            this.y = y;
            this.x = x;
            this.effort = effort;
        }

        @Override
        public int compareTo(State o) {
            return effort - o.effort;
        }
    }

    static int N, M;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static boolean[][] visited;

    static boolean isOutOfBounds(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= M;
    }

    public static int solution(int[][] heights) {
        N = heights.length;
        M = heights[0].length;

        int[][] diff = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                diff[i][j] = Integer.MAX_VALUE;
            }
        }

        diff[0][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(0, 0, 0));

        visited = new boolean[N][M];

        while (!pq.isEmpty()) {
            State state = pq.poll();
            int y = state.y;
            int x = state.x;
            int effort = state.effort;

            if (y == N - 1 && x == M - 1) {
                return effort;
            }

            visited[y][x] = true;

            for (int k = 0; k < 4; k++) {
                int nextY = y + dy[k];
                int nextX = x + dx[k];

                if (isOutOfBounds(nextY, nextX)) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                int maxEffort = Math.max(diff[y][x],
                    Math.abs(heights[y][x] - heights[nextY][nextX]));

                if (diff[nextY][nextX] > maxEffort) {
                    diff[nextY][nextX] = maxEffort;

                    pq.add(new State(nextY, nextX, diff[nextY][nextX]));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2},
            {3, 10, 2},
            {5, 3, 5}
        };

        System.out.println(solution(heights));
    }
}
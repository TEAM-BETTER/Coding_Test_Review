package CodingTest12;

import java.util.PriorityQueue;

/**
 * 1. 저번 문제와 동일하고 단 한 번 벽을 부술 수 있다는 점이 추가됨
 *      -> State class 에 canDestroy 를 추가했습니다.
 *      -> 이동횟수가 적을수록 우선순위 높음 : cnt 순으로 정렬
 *
 * 2. 저번주와 같은 로직이며 visited 배열에 벽부수기 여부를 추가했습니다.
 *
 * 3. dy / dx 배열을 돌며 상하좌우 이동 가능 여부를 체크
 *      -> 벽이 있고 부술 수 있으면, 부수기 능력 없애고 pq에 추가
 *      -> 벽이 없고 방문 한 적 없으면 pq에 추가
 *
 * 4. pq값 꺼내며 이동 가능 지역 탐색 후
 *      -> 목적지 도착하면 cnt 리턴, 도착 못하고 pq값 비어있으면 -1리턴
 *
 */

class CodingTest5_김우진 {

    static class State implements Comparable<State> {

        int y;
        int x;
        int canDestroy;
        int cnt;

        public State(int y, int x, int canDestroy, int cnt) {
            this.y = y;
            this.x = x;
            this.canDestroy = canDestroy;
            this.cnt = cnt;
        }

        /**
         * 이동 횟수 적을수록 우선순위 높음
         */
        @Override
        public int compareTo(State o) {
            return cnt - o.cnt;
        }
    }

    static int[] dy = { 1, -1, 0, 0 };

    static int[] dx = { 0, 0, 1, -1 };

    public static int solution(int N, int M, int[][] maze) {
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(0, 0, 1, 0));

        boolean[][][] visited = new boolean[N][M][2]; // y, x, 부술 수 있는지 여부
        visited[0][0][1] = true; // 시작점에서는 벽을 부술 수 있는 능력이 살아있다

        while (!pq.isEmpty()) {
            State state = pq.poll();
            int y = state.y;
            int x = state.x;
            int canDestroy = state.canDestroy;
            int cnt = state.cnt;

            if (y == N - 1 && x == M - 1) {
                return cnt;
            }

            for (int k = 0; k < 4; k++) {
                int nextY = y + dy[k];
                int nextX = x + dx[k];

                if (nextY < 0 || nextY >= N) {
                    continue;
                }

                if (nextX < 0 || nextX >= M) {
                    continue;
                }

                if (maze[nextY][nextX] == 1
                        && canDestroy == 1
                        && visited[nextY][nextX][canDestroy - 1] == false) {
                    visited[nextY][nextX][canDestroy - 1] = true;

                    pq.add(new State(nextY, nextX, canDestroy - 1, cnt + 1));
                }


                if (maze[nextY][nextX] == 0
                        && visited[nextY][nextX][canDestroy] == false) {
                    visited[nextY][nextX][canDestroy] = true;

                    pq.add(new State(nextY, nextX, canDestroy, cnt + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 6;
        int M = 6;
        int[][] maze = {{0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0},
                        {1, 1, 1, 0, 0, 0}};

        System.out.println(solution(N, M, maze));
    }
}
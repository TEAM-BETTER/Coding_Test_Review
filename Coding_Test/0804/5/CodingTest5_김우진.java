package CodingTest11;

import java.util.PriorityQueue;

/**
 * PriorityQueue 사용 탐색
 *
 * 1. State class : y좌표, x좌표, cnt
 *      -> cnt 오름차순 정렬
 *      -> dy, dx 배열은 상하좌우 이동 좌표 배열
 *
 * 2. 시작 포인트인 좌표 0, 0과 cnt 0까지 pq에 초기값으로 넣어줍니다.
 *
 * 3. while 반복문으로 탐색을 시작하고 다음으로 이동 가능 한 좌표 값을 찾습니다.
 *      -> dy, dx 배열값을 통해 상하좌우로 이동 할 수 있는 값을 찾고
 *      갈 수 있으면 pq에 다음 좌표 x, y 값과 cnt 에 +1 된 값을 넣어주고 아니면 패스
 *
 * 4.  y와 x가 N-1, M-1에 도달하면 해당 pq 값의 cnt 값 리턴으로 탐색 종료
 *      -> pq 값이 없을 때 까지 반복했으나 도달하지 못했다면 미로탈출 불가능 : 리턴 -1;
 *
 */

class CodingTest5_김우진 {
    static class State implements Comparable<State> {

        int y;
        int x;
        int cnt;

        public State(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(State o) {
            return this.cnt - o.cnt;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static int solution(int N, int M, int[][] maze) {

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(0, 0, 0));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.y == N - 1 && cur.x == M - 1) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {

                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];

                if (nextY < 0 || nextY >= N) {
                    continue;
                }
                if (nextX < 0 || nextX >= M) {
                    continue;
                }

                if (maze[nextY][nextX] == 1 || visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;
                pq.add(new State(nextY, nextX, cur.cnt + 1));

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 6;
        int M = 6;
        int[][] maze = {{0, 0, 0, 0, 0, 0}
                , {0, 1, 1, 1, 1, 0}
                , {0, 1, 0, 0, 0, 0}
                , {1, 1, 0, 1, 0, 1}
                , {0, 0, 0, 0, 1, 0}
                , {1, 1, 1, 0, 0, 0}};

        System.out.println(solution(N, M, maze));
    }
}
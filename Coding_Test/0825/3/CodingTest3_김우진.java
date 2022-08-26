package CodingTest14;

import java.util.*;

/**
 * 정확성 : 10 효율성 : 8
 *
 * 1. State : y좌표, x좌표, 이동횟수 cnt
 *    -> cnt 는 작은 수를 앞으로 오름차순 정렬
 *    isNight : 현재 턴이 밤인지 확인
 *    init : tempMaze 배열에 2를 만나면 몬스터가 공격할 수 있는 상하좌우를 미리 2로 채움
 *    dy, dx : 상하좌우 움직이는 이동배열
 *
 * 2. PriorityQueue 를 이용해 pq에 x, y, cnt 를 0으로 초기화 한 값을 시작으로 maze 탐색 시작
 *      dy, dx를 통해 다음으로 이동할 수 있는 지 확인
 *      이동 조건 )지역이 범위 내에 있고, 벽이 아니고, 방문하지 않아야 함
 *               만약 현재 턴이 밤인데 2라면 이동 없이 밤이 아닐때 까지 턴만 넘겨서 cnt만 플러스 해줌
 *
 *      다음 이동 지역을 pq값에 넣고, 현재지역은 방문배열 true 변경 후 pq의 다음 데이터 확인
 *      -> pq 에 남은 데이터가 없고 목적지에 도달하지 못했으면 -1 리턴
 *      -> 목적지에 도달 했다면 cnt값 리턴
 *
 * ** 추가된 구문 : 다음 날이 밤이고 현재 칸과 다음 칸 모두 몬스터한테 공격받을 상황이면 continue;
 *
 */

public class CodingTest3_김우진 {

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
            return cnt - o.cnt;
        }
    }

    static boolean isNight(int cnt) {
        return (cnt / 5) % 2 == 1;
    }
    static void init(int[][] maze, int N, int M) {

        int[][] tempMaze = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                tempMaze[y][x] = maze[y][x];
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (tempMaze[y][x] != 2) {
                    continue;
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

                    if (tempMaze[nextY][nextX] == 1) {
                        continue;
                    }

                    maze[nextY][nextX] = 2;
                }
            }
        }
    }

    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    public static int solution(int[][] maze) {
        int N = maze.length;
        int M = maze[0].length;

        init(maze, N, M);

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(0, 0, 0));

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;

            if (y == N - 1 && x == M - 1) {
                return cnt;
            }

            for (int k = 0; k < 4; k++) {
                int nextY = y + dy[k];
                int nextX = x + dx[k];

                // maze 배열의 범위를 벗어나면 패스
                if (nextY < 0 || nextY >= N) {
                    continue;
                }

                if (nextX < 0 || nextX >= M) {
                    continue;
                }

                // 벽이거나 이미 방문한 지역이면 패스
                if (maze[nextY][nextX] == 1 || visited[nextY][nextX]) {
                    continue;
                }

                // 추가된 구문
                if (isNight(cnt + 1)
                        && maze[y][x] == 2
                        && maze[nextY][nextX] == 2) {
                    continue;
                }

                // 밤이고 maze값이 2이면 밤이 아닐 때 까지 cnt++로 턴만 넘겨줌
                if (isNight(cnt + 1) && maze[nextY][nextX] == 2) {
                    while (isNight(cnt + 1)) {
                        cnt++;
                    }
                }

                // 위의 모든 조건 통과했다면 현재 지역은 방문 true
                // 다음 이동 가능한 데이터는 pq에 담아줌
                visited[nextY][nextX] = true;
                pq.add(new State(nextY, nextX, cnt + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 2, 0, 0 },
                { 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0 },
                { 1, 1, 1, 0, 2, 0 }
        };

        System.out.println(solution(maze));
    }
}
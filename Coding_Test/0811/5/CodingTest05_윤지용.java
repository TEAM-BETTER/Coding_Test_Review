/*
아이디어
폭탄 사용했는지 안했는지 체크를 위해 Here클래스를 만들고
bfs에 넣어서 돌리기
 */
// 정확성 8 / 10, 효율성 8 / 10 나왔습니다....

import java.util.LinkedList;
import java.util.Queue;

public class CodingTest05 {
    static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;

    static class Here {
        int x;
        int y;
        int moveCnt;
        int bomb; // 폭탄 가지고 있는 개수

        public Here(int x, int y, int moveCnt, int bomb) {
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
            this.bomb = bomb;
        }
    }

    public static int solution(int N, int M, int[][] maze) {
        visited = new boolean[N][M];
        int answer = bfs(0, 0, N, M, maze);

        return answer;
    }

    public static int bfs(int x, int y, int N, int M, int[][] maze) {
        Queue<Here> q = new LinkedList<>();
        if(maze[0][0] == 1) { // 시작점이 1일 경우 예외처리
            q.offer(new Here(0, 0, 0, 0));
        } else {
            q.offer(new Here(0, 0, 0, 1)); // 폭탄 1개 가지고 시작
        }
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Here now = q.poll();

            // 도착하면 리턴
            if (now.x == M - 1 && now.y == N - 1) {
                return now.moveCnt;
            }

            for (int[] d : dir) {
                int nextY = now.y + d[0];
                int nextX = now.x + d[1];
                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && !visited[nextY][nextX]) { // 그리드 안이고 방문 안했으면
                    if (maze[nextY][nextX] == 0) { // 벽이 아니라 그냥 갈 수 있으면
                        q.add(new Here(nextY, nextX, now.moveCnt + 1, now.bomb));
                        visited[nextY][nextX] = true;
                    } else { // 벽이면
                        if(now.bomb == 1) { // 폭탄 가지고 있으면 갈수 있음
                            q.add(new Here(nextY, nextX, now.moveCnt + 1, now.bomb - 1));
                            visited[nextY][nextX] = true;
                        }
                    }
                }
            }
        }
        return -1; // 여기까지 오면 탈출 못한거
    }


    public static void main(String[] args) {
        int[][] maze = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0}, {1, 1, 1, 0, 0, 0}};
        int N = 6;
        int M = 6;
        System.out.println(solution(N, M, maze));
    }
}

/*
 * 귀우님 규빈님이 추천해주셨던 문제였습니다 ❤️
 * 덱으로 구현한건 단순히 큐보다 빨라서 구현했습니다!!
 * */
import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Point {
        int x;
        int y;
        int step;           // 이동 횟수
        int isCrushed;      // 폭탄을 안 쓴 경우 = 0, 쓴 경우 = 1

        public Point(int x, int y, int step, int isCrushed) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.isCrushed = isCrushed;
        }
    }
    public int solution(int N, int M, int[][] maze) {
        ArrayDeque<Point> q = new ArrayDeque<Point>();
        q.add(new Point(0, 0, 0, 0));   // 초기 상태 값
        boolean[][][] visited = new boolean[2][N][M];
        // 폭탄을 쓴 경우의 visitied도 판별하기 위해 3차원 배열로 만들었습니다.
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N - 1 && p.y == M - 1)       // 도착한 경우 이동거리 리턴
                return p.step;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M ||
                        (maze[nx][ny] == 1 && p.isCrushed == 1))
                    // 예외 처리
                    continue;

                int isCrushed = p.isCrushed;

                if (maze[nx][ny] == 1 && p.isCrushed == 0)
                    isCrushed = 1;
                if (visited[isCrushed][nx][ny]) continue;
                // 3차원 배열 활용을 위해 isCrushed 필드를 boolean으로 안하고
                // int 타입으로 선언했습니다.

                q.add(new Point(nx, ny, p.step + 1, isCrushed));
                // 4가지 방향 큐에 추가
                visited[isCrushed][nx][ny] = true;
            }
        }
        return -1;      // 반복문에서 리턴되지 않을 시 탈출할 수 없는 경우
    }
}
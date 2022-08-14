import java.util.LinkedList;
import java.util.Queue;

// BFS를 이용하여 거리 측정
class Solution {
    // 좌표를 나타내기위한 클래스
    static class Pos {
        int x; //행
        int y; //열

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 순서대로 위 오른쪽 아래 왼쪽
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0 ,1 ,0, -1};
    int[][] dis; // 거리

    public int solution(int N, int M, int[][] maze) {
        dis = new int[N][M];

        //BFS
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0));

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nextX = cur.x + dx[direction];
                int nextY = cur.y + dy[direction];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (maze[nextX][nextY] == 1) continue;
                if (dis[nextX][nextY] > 0) continue;
                dis[nextX][nextY] = dis[cur.x][cur.y] + 1;
                queue.add(new Pos(nextX, nextY));
            }
        }
        // 방문 불가능하면 -1
        return dis[N-1][M-1] == 0 ? -1 : dis[N-1][M-1];
    }


}
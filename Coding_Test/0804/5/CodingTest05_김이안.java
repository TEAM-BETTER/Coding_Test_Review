import java.util.*;
class Solution {
    static final int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int solution(int N, int M, int[][] maze) {
        boolean[][]visited = new boolean[N][M];
        bfs(0,0,maze,visited);
        return -maze[N-1][M-1] == 0 ? -1 : -maze[N-1][M-1];
    }
    public static void bfs(int x, int y, int[][] maze, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dir[i][0];
                int nextY = nowY + dir[i][1];

                if (nextX < 0 || nextY < 0 || nextX >= maze[0].length || nextY >= maze.length)
                    continue;
                if (visited[nextY][nextX] || maze[nextY][nextX] == 1)
                    continue;

                q.add(new int[] {nextX, nextY});
                maze[nextY][nextX] = maze[nowY][nowX] - 1;
                visited[nextY][nextX] = true;
            }
        }
    }
}
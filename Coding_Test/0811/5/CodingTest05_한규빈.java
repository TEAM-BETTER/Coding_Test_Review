package CodingTest5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 일반적인 bfs에서 벽을 부술 수 있다는 조건이 추가되어 좀 어려웠던 문제...
 * https://www.acmicpc.net/problem/2206
 */
public class CodingTest5_한규빈 {

    static class Node {
        private int row;
        private int col;
        private int count;
        private int wall;

        public Node(int row, int col, int count, int wall) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.wall = wall;
        }
    }

    static boolean[][][] visited;
    static int[][] dist;
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};
    static int row, col;
    public static int solution(int N, int M, int[][] maze) {
        row = N;
        col = M;
        dist = new int[row][col];

        // 벽을 부수고 탐색하는 경우와 그렇지 않은 경우를 처리하기위한 visited 배열
        visited = new boolean[row][col][2];

        return bfs(0, 0, maze);
    }

    public static int bfs(int r, int c, int[][] maze) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 0, 0));
        visited[r][c][0] = true;
        visited[r][c][1] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            // 미로의 출구에 도착했다면 count 값 반환
            if (current.row == row - 1 && current.col == col - 1) return current.count;

            for (int i = 0; i < 4; i++) {
                int nx = current.row + drow[i];
                int ny = current.col + dcol[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    // 벽이 아닐 때
                    if(maze[nx][ny] == 0) {
                        // 현재까지 온 방법(벽을 부쉈는지 아닌지)으로 방문한 적이 없다면 방문한다.
                        if (visited[nx][ny][current.wall] == false) {
                            q.add(new Node(nx, ny, current.count + 1, current.wall));
                            visited[nx][ny][current.wall] = true;
                        }
                    }

                    // 벽일때
                    else if (maze[nx][ny] == 1) {
                        if (current.wall == 0 && visited[nx][ny][1] == false) {
                            // 현재까지 벽을 부순적이 없고, 벽을 부숴서 방문한 적이 없다면 방문한다.
                            q.add(new Node(nx, ny, current.count + 1, 1));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }

        }

        // queue에 값이 없으면 -1을 반환
        return -1;
    }

    public static void main(String[] args) {
        int N = 6;
        int M = 6;
        int[][] maze = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0},
                {1, 1, 1, 0, 0, 0}
        };
        System.out.println(solution(N, M ,maze));
    }
}

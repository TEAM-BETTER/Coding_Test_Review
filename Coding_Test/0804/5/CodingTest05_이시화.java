package codiingTest.codingTest11.p5;

import java.util.Arrays;
import java.util.PriorityQueue;

// priorityQueue 를 이용한 bfs 문제
public class Solution {
    public static int solution(int N, int M, int[][] maze) {
        if (maze[N - 2][M - 1] == 1 && maze[N - 1][M - 2] == 1) { // 도착지가 막혀 있는 것을 예외 처리
            return -1;
        }

        int INF = Integer.MAX_VALUE;            // DP 초기화를 위한 변수
        int[] dx = {1, 0, -1, 0};               // 아래, 위, 왼쪽, 오른쪾 이동을 위한 배열
        int[] dy = {0, 1, 0, -1};

        int[][] dp = new int[N][M];             // DP 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[2] - y[2]);    // priorityQueue 를 만들어 BFS 시작
        queue.add(new int[]{0, 0, 0});     // {x, y, distance}

        while (!queue.isEmpty()) {          // bfs 시작
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];
            if (x == N - 1 && y == M - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (isPossible(newX, newY, maze, N, M) && dp[newX][newY] > dis + 1) {
                    queue.add(new int[]{newX, newY, dis + 1});
                    dp[newX][newY] = dis + 1;
                }
            }
        }

        if (dp[N - 1][M - 1] == INF) {          // 도착지에 도달 할수 있는지 없는지 확인
            return -1;
        } else {
            return dp[N - 1][M - 1];
        }
    }

    public static boolean isPossible(int x, int y, int[][] maze, int N, int M) {
        return x >= 0 && y >= 0 && x < N && y < M && maze[x][y] == 0;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0}, {1, 1, 1, 0, 0, 0}};
        System.out.println(solution(6, 6, m));
    }
}

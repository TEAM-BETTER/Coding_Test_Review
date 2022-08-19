package codiingTest.codingTest12.p5;


import java.util.PriorityQueue;

// 저번주 5번문제에서 벽을 부수는 부분을 추가한 문제
public class Solution {
    public static int solution(int N, int M, int[][] maze) {
        int INF = Integer.MAX_VALUE;            // DP 초기화를 위한 변수
        int[] dx = {1, 0, -1, 0};               // 아래, 위, 왼쪽, 오른쪾 이동을 위한 배열
        int[] dy = {0, 1, 0, -1};

        int[][][] dp = new int[N][M][2];             // DP 초기화  // dp 를 3차원으로 만들어 [][][1]은 벽을 부순 후를 업데이트
        for (int i = 0; i < N; i++) {                // [][][0] 은 벽을 부수기 전을 업데이트
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[2] - y[2]);    // priorityQueue 를 만들어 BFS 시작
        queue.add(new int[]{0, 0, 0, 0});     // {x, y, distance, 벽 부순여부(0이면 부술 수 있음, 1이면 부순 후)}

        while (!queue.isEmpty()) {          // bfs 시작
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];
            int bomb = cur[3];
            if (x == N - 1 && y == M - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (bomb == 1) {             // 폭탄 없을 때
                    if (isPossible(newX, newY, maze, N, M) && maze[newX][newY] == 0 && dp[newX][newY][1] > dis + 1) {
                        queue.add(new int[]{newX, newY, dis + 1, 1});
                        dp[newX][newY][1] = dis + 1;
                    }
                }
                if (bomb == 0) {             // 폭탄 있을 때
                    if (isPossible(newX, newY, maze, N, M)) {
                        if (maze[newX][newY] == 1 && dp[newX][newY][1] > dis + 1) {     // 폭탄을 사용 할 때
                            queue.add(new int[]{newX, newY, dis + 1, 1});
                            dp[newX][newY][1] = dis + 1;
                        }
                        if (maze[newX][newY] == 0 && dp[newX][newY][0] > dis + 1) {     // 폭탄을 사용하지 않을 때
                            queue.add(new int[]{newX, newY, dis + 1, 0});
                            dp[newX][newY][0] = dis + 1;
                        }
                    }
                }
            }
        }

        if (dp[N - 1][M - 1][1] == INF && dp[N - 1][M - 1][0] == INF) {          // 도착지에 도달 할수 있는지 없는지 확인
            return -1;
        } else {
            return Math.min(dp[N - 1][M - 1][1], dp[N - 1][M - 1][0]);
        }
    }

    public static boolean isPossible(int x, int y, int[][] maze, int N, int M) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}


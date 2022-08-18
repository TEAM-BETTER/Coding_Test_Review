import java.util.*;

/**
 * 운좋게 백준에 풀었던 문제였습니다. 지난주 미로문제 못푼게 억울해서 찾다가 여기까지 풀게 되었습니다.
 * https://www.acmicpc.net/problem/2206
 * 3차원 배열을 이용해서 폭탄을 가지고 방문하는 경우와 가지고 있지 않은 경우로 해서 방문 처리를 해주어야 합니다.
 * 나머지는 그냥 지난주 미로 문제랑 똑같습니다.
 */

class Solution {
    public int solution(int N, int M, int[][] maze) {
        int[] dirs = { 0, 1, 0, -1, 0 }; // 상하좌우 움직임
        int[][] dp = new int[N][M]; // 거리 기록할 배열
        boolean[][][] visit = new boolean[N][M][2]; // 0번은 폭탄 가지고 있는경우,1번은 폭탄을 사용한경우

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { 0, 0, 0 }); // 배열 3개로 row,col,bomb 를 표현해줍니다.

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], isBomb = cur[2];
            if (r == N - 1 && c == M - 1) {
                return dp[r][c];
            }
            for (int i = 1; i < dirs.length; i++) {
                int row = r + dirs[i];
                int col = c + dirs[i - 1];

                if (row < 0 || row >= N || col < 0 || col >= M)
                    continue;

                if (maze[row][col] == 1 && isBomb == 0) { // 현재폭탄이 있고, 벽이라면 ?
                    visit[row][col][1] = true;
                    dp[row][col] = dp[r][c] + 1;
                    q.offer(new int[] { row, col, 1 });
                }
                if (maze[row][col] == 0) { // 벽이 아니라면
                    if (isBomb == 0 && !visit[row][col][0]) { // 폭탄의 소유 여부에 따라 visit 을 달리체크해줍니다.
                        visit[row][col][0] = true;
                        dp[row][col] = dp[r][c] + 1;
                        q.offer(new int[] { row, col, 0 });
                    } else if (isBomb == 1 && !visit[row][col][1]) {
                        visit[row][col][1] = true;
                        dp[row][col] = dp[r][c] + 1;
                        q.offer(new int[] { row, col, 1 });
                    }
                }
            }
        }
        return -1;
    }
}
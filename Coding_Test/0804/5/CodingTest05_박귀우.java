
/**
 * 정말이지 여기서 하얗게 불태우고 맥북 부실뻔했습니다.
 * 0,0 부터 마지막 까지 찾아가는 길찾기 문제 여서 bfs 로 접근했습니다.
 * dp 배열을 추가적으로 만들어주어서 거리를 기록하면서 이동하는 방식으로 접근했습니다. 
 * 만약 끝점 주변으로 1이감싸져 있다면 근접할수 없기 때문에 0,0 이 아닌 끝점에서 0,0 으로 거슬러갈 생각을했습니다.
 * 정확성 만 통과된 코드입니다.
 */

import java.util.*;

class Solution5 {
    public int solution(int N, int M, int[][] maze) {
        if (maze[N - 1][M - 1] == 1)
            return -1; // 끝점이 -1 이면 영영도착할수 없음
        int[] dirs = { 0, 1, 0, -1, 0 };
        int[][] dp = new int[N][M];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[N - 1][M - 1] = 0;
        // boolean[][] visit = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { N - 1, M - 1 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 1; i < dirs.length; i++) {
                int row = cur[0] + dirs[i - 1]; // 이동 row
                int col = cur[1] + dirs[i]; // 이동 col
                if (0 <= row &&
                        row < N &&
                        0 <= col &&
                        col < M &&
                        maze[row][col] != 1 &&
                        dp[row][col] == Integer.MAX_VALUE) {
                    int next = dp[cur[0]][cur[1]] + 1;
                    if (dp[cur[0]][cur[1]] > next)
                        continue; // 다음 이동값보다 현재 dp 가 크다면 넘겨줍니다. 이쪽 넘기는 부분이나 다음 으로 넘어가는 부분 이 잘못된것 같습니다.
                    dp[row][col] = next; // 업데이트 해주고
                    q.add(new int[] { row, col }); // row,col 을 queue 에 넣어줍니다.
                }
            }
        }
        if (dp[0][0] == Integer.MAX_VALUE)
            return -1;
        return dp[0][0];
    }
}
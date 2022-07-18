
/**
 * 음 냅다 bfs 시전하고 테케만 통과하고 다틀렸습니다. ㅎㅎ
 * 끝나고 이안님이랑 이야기 나누고 보니 key 를 기준으로 나눠서 돌리면 되겠더라고요.. ㅠ
 * 토요일날 테스트해보고 업데이트 하겠습니다 .!
 * row,col 을 이용해서 오른쪽 혹은 아래로만 갈수 있기떄문에 방향설정
 * bfs 를 작성하다 보니 키를 현재 가지고 있는지 판별하기가 어려워서 그냥 배열을 한칸더만들어 주어서 해결했습니다.
 */

import java.util.*;

class Solution {
    int count;

    public int solution(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[] key = null;
        loop: for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 2) {
                    key = new int[] { i, j };
                    break loop;
                }
            }
        }
        if (kep == nul)
            return 0;
        // to key
        int toKey = fromTo(new int[] { 0, 0 }, key, 1, maze);
        // to end
        return fromTo(key, new int[] { m - 1, n - 1 }, start, maze);
    }

    public int fromTo(int[] a, int[] b, int start, int[][] maze) {
        int m = b[0] - a[0] + 1;
        int n = b[1] - a[1] + 1;
        int[][] dp = new int[m][n];
        // row
        for (int i = 0; i < dp.length; i++) {
            if (maze[a[0]][a[1] + i] == 1)
                break;
            dp[0][i] = start;
        }
        // col
        for (int i = 0; i < dp.length; i++) {
            if (maze[a[0] + i][a[1]] == 1)
                break;
            dp[i][0] = start;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (maze[a[0] + i][a[1] + j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1007;
                }
            }
        }

        return dp[m + 1][n + 1];
    }
}

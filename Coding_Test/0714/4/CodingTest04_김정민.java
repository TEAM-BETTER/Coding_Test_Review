/*
* 고등학교 확률과 통계 길찾기 문제에서 손으로 일일이 세는 방식으로 했던게 생각이나서 풀이를 작성 했습니다.
* dp[i][j]는 (i,j)로 올때 최소 값
* dp[i][j] = dp[i-1][j] + d[i][j-1]
* 1. 열쇠를 가지지 않고 통과를 하면 무효이기 때문에 열쇠를 찾을 때 까지 dp 테이블을 채워 줍니다.
* 2. 열쇠에서 탈출할 때 까지 다시 테이블을 채워 준 후 결과를 반환 합니다.
*
* 정확성: 10
* 효율성: 8점
* 효율성 1번에서 시간초과가 아니라 실패가 뜨는걸 보니까 예외 케이스가 있는거 같은데 아직 확인을 못했습니다.
* */
class Solution {
    public int solution(int[][] maze) {
        int answer = 0;

        int[][] dp = new int[maze.length][maze[0].length];

        int n = maze.length-1;
        int m = maze[0].length-1;

        // 끝 부분이 벽으로 둘러 싸여 있다면 탈출은 불가능 합니다.
        if (maze[n-1][m] == 1 && maze[n][m-1] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        int keyRow = 0;
        int keyCol = 0;

        // 열쇠를 찾을 때 까지 테이블을 채워줍니다.
        Outer:
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (maze[i][j] == 1 || (i == 0 && j == 0)) continue;

                if (j-1 >= 0) {
                    dp[i][j] += dp[i][j-1];
                    dp[i][j] %= 1007;
                }

                if (i-1 >= 0) {
                    dp[i][j] += dp[i-1][j];
                    dp[i][j] %= 1007;
                }
                // 열쇠를 찾는다면 전체 반복문을 종료합니다.
                if (maze[i][j] == 2) {
                    keyRow = i;
                    keyCol = j;
                    break Outer;
                }
            }
        }

        // 열쇠까지 가는 경우의 수가 없다면 탈출은 불가능합니다.
        if (dp[keyRow][keyCol] == 0) return 0;

        // 열쇠에서 탈출하는 경로까지 다시 dp테이블을 채워 줍니다.
        for (int i = keyRow; i <= n; i++) {
            for (int j = keyCol; j <= m; j++) {
                if (maze[i][j] == 1 || (i == keyRow && j == keyCol)) continue;

                if (j-1 >= keyCol) {
                    dp[i][j] += dp[i][j-1];
                    dp[i][j] %= 1007;
                }

                if (i-1 >= keyRow) {
                    dp[i][j] += dp[i-1][j];
                    dp[i][j] %= 1007;
                }
            }
        }

        return dp[maze.length-1][maze[0].length-1];
    }
}
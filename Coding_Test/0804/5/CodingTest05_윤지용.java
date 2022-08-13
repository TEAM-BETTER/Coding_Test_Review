// dfs로 시도했는데 정확성 6 / 10, 효율성 0 / 10 나왔습니다. 정확성에서도 시간초과나네요..
/*
아이디어
dfs
 */

public class CodingTest05_윤지용 {
    static int[][] dp;
    static boolean[][] visited;
    static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int solution(int N, int M, int[][] maze) {
        int answer = 0;
        dp = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        visited[0][0] = true;

        dfs(0, 0, maze, N, M, 0);

        return (dp[N-1][M-1] == Integer.MAX_VALUE) ? -1 : dp[N-1][M-1];
    }

    public static void dfs(int a, int b, int[][] maze, int N, int M, int answer) {
        if(a == N - 1 && b == M - 1) {
            return;
        }
        for (int[] d : dir) {
            int x = a + d[0];
            int y = b + d[1];
            if(x >= 0 && y >= 0 && x < N && y < M && maze[x][y] == 0 && !visited[x][y]) {
                visited[a][b] = true;
                answer = dp[a][b] + 1;
                dp[x][y] = Math.min(dp[x][y], answer);
                dfs(x, y, maze, N, M, dp[x][y]);
                visited[a][b] = false;
            }
        }


/*      2번째 풀이. dp배열때문에 시간초과가 나려나 해서 이동 횟수를 dfs에 넘겨주는 식으로 했지만, 역시 시간초과.
        static boolean[][] visited;
        static int answer;
        static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public static int solution(int N, int M, int[][] maze) {
            if((maze[N-2][M-1] == 1) && (maze[N-1][M-2] == 1)) {
                return -1;
            }
            visited = new boolean[N][M];
            visited[0][0] = true;

            dfs(0, 0, maze, N, M, 0);

            return answer;
        }

        public static void dfs(int a, int b, int[][] maze, int N, int M, int cnt) {
            if(a == N - 1 && b == M - 1) {
                answer = cnt;
                return;
            }

            for (int[] d : dir) {
                int x = a + d[0];
                int y = b + d[1];
                if(x >= 0 && y >= 0 && x < N && y < M && maze[x][y] == 0 && !visited[x][y]) {
                    visited[a][b] = true;
                    dfs(x, y, maze, N, M, cnt + 1);
                    visited[a][b] = false;
                }
            }
 */
    }

    public static void main(String[] args) {
        int N = 6;
        int M = 6;
        int[][] maze = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0}, {1, 1, 1, 0, 1, 0}};
        System.out.println(solution(N, M, maze));
    }
}


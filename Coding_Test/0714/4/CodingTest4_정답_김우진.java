package CodingTest8;

public class CodingTest4_정답_김우진 {

    public static int MOD = 1007;

    public static int findWays(int startY, int startX, int endY, int endX, int init, int[][] maze) {
        int N = endY - startY + 1;
        int M = endX - startX + 1;
        int[][] cache = new int[N][M];

        for (int y = 0; y < N; y++) {
            if (maze[startY + y][startX] == 1) {
                break;
            }

            cache[y][0] = init;
        }

        for (int x = 0; x < M; x++) {
            if (maze[startY][startX + x] == 1) {
                break;
            }

            cache[0][x] = init;
        }

        for (int y = 1; y < N; y++) {
            for (int x = 1; x < M; x++) {
                if (maze[startY + y][startX + x] == 1) {
                    cache[y][x] = 0;
                } else {
                    cache[y][x] = (cache[y - 1][x] + cache[y][x - 1]) % MOD;
                }
            }
        }

        return cache[N - 1][M - 1];
    }

    public static int solution(int[][] maze) {
        int keyY = -1, keyX = -1;
        int N = maze.length;
        int M = maze[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 2) {
                    keyY = i;
                    keyX = j;

                    break;
                }
            }

            if (keyY != -1) {
                break;
            }
        }

        int waysToKey = findWays(0, 0, keyY, keyX, 1, maze);

        if (waysToKey == 0) {
            return 0;
        }

        return findWays(keyY, keyX, N - 1, M - 1, waysToKey, maze);
    }
}

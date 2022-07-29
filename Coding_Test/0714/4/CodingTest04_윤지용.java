
// 풀지 못했습니다.
// 접근 아이디어는 이랬습니다.
// 1. Key를 찾을때까지는 dfs로 찾아간다. (dir1 배열 사용하여)
// 2. Key를 찾으면 그때부터는 출구를 향해서만 간다. (dir2 배열을 사용하여)
// 3. 정답은 Key를 찾을때까지의 dp값 X 키부터 출구까지의 dp값
// 아이디어는 생각했지만, 틀린지 맞은지도 모르고, 구현도 못했습니다 ㅋㅋ

public class CodingTest04_윤지용 {
    static int[][] dir1 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dir2 = {{1, 0}, {0, 1}};
    static int[][] dp;
    static boolean[][] visited;
    static int[] keyIdx = new int[2];
    static boolean keyFlag = false;
    public static int solution(int[][] maze) {
        if(maze[1][0] == 1 && maze[0][1] == 1) {
            return 0;
        }
        if(maze[0][0] == 2) {
            keyIdx = new int[] {0, 0};
            keyFlag = true;
        }

        dp = new int[maze.length][maze[0].length];
        visited = new boolean[maze.length][maze[0].length];

        dp[0][0] = 0;

        if(keyFlag == false) {
            dfs(0, 0, maze);
        }

        return 1;
    }

    public static void dfs(int a, int b, int[][] maze) {
        if(keyFlag = false) {
            for (int[] d : dir1) {
                int x = a + d[0];
                int y = b + d[1];
                if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    visited[x][y] = true;
                    dp[x][y] = dp[a][b] + 1;
                    if (maze[x][y] == 2) {
                        keyFlag = true;
                        keyIdx = new int[]{x, y};
                    } else {
                        dfs(x, y, maze);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

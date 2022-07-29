package ch04.codingTest8.p4;

// 점수가 거의 얻지 못한 문제 입니다.
// DP 를 이용하여 풀었습니다.
public class Solution {
    public static int solution(int[][] maze) {
        int answer = 0;
        int[][] dp = new int[maze.length][maze[0].length];  // dp 를 위한 배열
        dp[0][0] = 1;                                       // 출발점 DP 1 로 초기화
        int[] key = new int[2];                             // 열쇠 위치 저장 배열

        for (int i = 0; i < maze.length; i++) {             // 열쇠가 있는 위치 찾기
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 2) {
                    key = new int[]{i, j};
                    break;
                }
            }
        }

        cur(0, 0, maze, dp, key);                      // 열쇠가 있는 곳 까지 dp 배열 업데이트

        if (dp[key[0]][key[1]] == 0) {                       // 열쇠가 있는 방에 도달 할 수 없다면 0 리턴
            return 0;
        }

        cur(key[0], key[1], maze, dp, new int[]{maze.length - 1, maze[0].length - 1});  // 열쇠가 있는 방 부터 끝까지 dp 없데이트

        return dp[maze.length - 1][maze[0].length - 1] % 1007;
    }

    public static void cur(int x, int y, int[][] maze, int[][] dp, int[] goalPoint) {
        // 목표 지점보다 오른쪽이나 더 아래로 내려가지 않기 위한 조건문
        if (x > goalPoint[0] || y > goalPoint[1] || (x == goalPoint[0] && y == goalPoint[1])) {
            return;
        }

        if (isPossible(x + 1, y, maze)) {               // 갈수 있는 곳인지 확인하는 메소드
            dp[x + 1][y] += dp[x][y];                      // x, y 까지 올수 있는 경우의 수를 아래 방향의 dp에 더해줌
            dp[x + 1][y] %= 1007;
            cur(x + 1, y, maze, dp, goalPoint);         // 재귀로 다음 포인트 이동 실행
        }

        if (isPossible(x, y + 1, maze)) {               // 위와 마찬가지로 오른쪽으로 이동하는 코드
            dp[x][y + 1] += dp[x][y];
            dp[x][y + 1] %= 1007;
            cur(x, y + 1, maze, dp, goalPoint);
        }
    }

    public static boolean isPossible(int x, int y, int[][] maze) {      // 다음 지점이 배열 사이즈 안에 있고, 갈수 있는 방인지 확인하는 메소드
        return x < maze.length && y < maze[0].length && (maze[x][y] == 0 || maze[x][y] == 2);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 1, 0}, {0, 2, 0}, {1, 0, 0}};
        System.out.println(solution(a));
        a = new int[][]{{0, 1, 0, 0}, {1, 2, 0, 0}, {1, 0, 0, 0}};
//        System.out.println(solution(a));


    }
}




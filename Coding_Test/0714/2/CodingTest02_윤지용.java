public class CodingTest02_윤지용 {
    public static int solution(int depth, int n, int[][] blocks) {
        // 예외 처리
        if(depth == 0) {
            return blocks[0][n];
        }

        int witdh = blocks[0].length;
        // 2차원 배열 dp는 해당 위치까지 땅을 팔 때 가장 적은 에너지
        int[][] dp = new int[depth + 1][witdh];

        // dp배열에 첫줄 입력
        for (int i = 0; i < witdh; i++) {
            dp[0][i] = blocks[0][i];
        }

        for (int i = 1; i < depth + 1; i++) {
            for (int j = 0; j < witdh; j++) {
                if(j == 0) { // 맨 왼쪽이면 윗줄의 바로 위나 오른쪽 중에서 최소값 + 본인블럭 에너지
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + blocks[i][j];
                } else if(j == witdh - 1) { // 맨 오른쪽이면 윗줄의 바로 위나 왼쪽 중에서 최소값 + 본인블럭 에너지
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + blocks[i][j];
                } else { // 중간인 경우 윗줄 왼쪽, 가운데, 오른쪽 중 최소값 + 본인블럭 에너지
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1])) + blocks[i][j];
                }
            }
        }

        return dp[depth][n];
    }

    public static void main(String[] args) {
        int depth = 3;
        int n = 3;
        int[][] blocks = {{5, 6, 2, 6}, {1, 6, 4, 9}, {5, 6, 9, 4}, {55, 14, 21, 14}};
        System.out.println(solution(depth, n, blocks));
    }
}
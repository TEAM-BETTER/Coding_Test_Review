public class CodingTest2_지용님 {
    public int solution(int depth, int n, int[][] blocks) {
        // 예외 처리
        if (depth == 0) {
            return blocks[0][n];
        }

        int witdh = blocks[0].length;
        // 2차원 배열 dp는 해당 위치까지 땅을 팔 때 가장 적은 에너지
        int[][] dp = new int[depth + 1][witdh];

        // dp배열에 첫줄 입력
        for (int i = 0; i < witdh; i++) {
            dp[0][i] = blocks[0][i];
        }
        Arrays.sort(dp[0]); // depth = 0일때 최솟값 찾기 위해 정렬
        for (int i = 1; i < depth + 1; i++) {
            dp[i] = new int[blocks[i].length]; // 각 depth마다 최대 열은 다르므로, i를 돌면서 모든 열의 length를 초기화
            for (int j = 0; j < blocks[i].length; j++) {
                if (i == 1) { // depth = 0에 위치한 블럭은 자유롭게 제거 가능
                    dp[i][j] = blocks[i][j] + dp[0][0];
                } else {
                    if (j == 0) { // 맨 왼쪽이면 윗줄의 바로 위나 오른쪽 중에서 최소값 + 본인블럭 에너지
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + blocks[i][j];
                    } else if (j == dp[i].length - 1) { // 맨 오른쪽이면 윗줄의 바로 위나 왼쪽 중에서 최소값 + 본인블럭 에너지
                        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + blocks[i][j];
                    } else { // 중간인 경우 윗줄 왼쪽, 가운데, 오른쪽 중 최소값 + 본인블럭 에너지
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + blocks[i][j];
                    }
                }
            }
        }

        return dp[depth][n];
    }

    public static void main(String[] args) {
        int depth = 3;
        int n = 0;
//        int[][] blocks = {{1,2,4}, {1,6,4,9}, {5,6,9,4}, {55,14,21,14}}; // 반례 해결
        int[][] blocks = {{3,2,4,1}, {1,6,4,9}, {5,6,9,4}, {55,14,21,14}}; // 반례 해결
        System.out.println(new CodingTest2_지용님().solution(depth, n, blocks));
    }
}

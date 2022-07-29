public class Solution {
    public static int[][] solution(int[][] image, int K) {
        int xLen = image.length;                // image 행 길이
        int yLen = image[0].length;             // image 열 길이
        int[][] answer = new int[xLen][yLen];   // 출력할 정답을 기록할 배열
        int sum = 0;                            //  K * K 개의 합을 담을 배열

        for (int i = 0; i < K / 2 + 1; i++) {   // 0, 0 일 때 값을 계산
            for (int j = 0; j < K / 2 + 1; j++) {
                if (isPossible(i, j, xLen, yLen)) {
                    sum += image[i][j];
                }
            }
        }
        answer[0][0] = sum / (K * K);           // 0, 0 일 때 값을 저장

        boolean down = false;                   // 밑으로 갈지
        boolean left = false;                   // 왼쪽으로 갈지 오른쪽으로 갈지 확인 할 수 있는 변수
        int x = 0;
        int y = 0;                              // 시작 x, y 값

        while (true) {                          // 0,0 에서 오른쪽 끝까지 갔다가 1행 내려와서 다시 오른쪽 끝까지 갔다가 1행 내려오고 다시 왼쪽으로
            // 내려오는 것을 반복하면서 각 칸을 채움

            if (down) {                         // 밑으로 내려갈 경우
                if (y == yLen - 1) {            // 오른쪽 끝일 때 행 값을 증가시키며 다음에 오른쪽으로 가도록 설정
                    x++;
                    left = true;
                } else if (y == 0) {            // 왼쪽 끝일 때 행값을 증가시키며 다음에 왼쪽으로 가도록 설정
                    x++;
                    left = false;
                }
                if (x >= xLen) {                // 다음 행이 배열의 밖일 경우 반복문 멈춤
                    break;
                }

                sum = curSum(x, y, K, sum, xLen, yLen, image, true, false);  //sum 값을 효율적으로 구하는 함수 K * K 다 해주면 너무 오래걸림
                answer[x][y] = sum / (K * K);                               // 정답 저장

                down = false;                                               // down 값 초기화
            }

            if (left) {                                                     // 왼쪽으로 갈 떄
                y--;
                sum = curSum(x, y, K, sum, xLen, yLen, image, false, true);
                answer[x][y] = sum / (K * K);

                if (y == 0) {                                               // 끝에 도달하면 down 값 올려줌
                    down = true;
                }
            } else {                                                        // 오른쪽으로 갈 때
                y++;
                sum = curSum(x, y, K, sum, xLen, yLen, image, false, false);
                answer[x][y] = sum / (K * K);

                if (y == yLen - 1) {                                        // 끝에 도달하면 down 값 올려줌
                    down = true;
                }
            }


        }

        return answer;
    }

    public static int curSum(int x, int y, int K, int sum, int xLen, int yLen, int[][] image, boolean down, boolean left) {
        // 아래로 내려갈 때, 오른쪽으로 갈 때, 왼쪽으로 갈 때 구분해서 실행
        // 또한 모든 K * K 값을 모두 실행하지 않고
        // 이전 sum 값에서 제외되는 값만 빼고 추가되는 값만 더해줌
        // 이 방법으로  K * K 개만큼 더해야하는 과정을 K + K 번만 수행 할 수 있음
        // 자료구조 Queue 를 통해 구현하려 했지만 너무 복잡해져서 그냥 구현함

        if (down) {
            for (int i = -K / 2; i < K / 2 + 1; i++) {
                if (isPossible(x - K / 2 - 1, y - i, xLen, yLen)) {
                    sum -= image[x - K / 2 - 1][y - i];
                }

                if (isPossible(x + K / 2, y + i, xLen, yLen)) {
                    sum += image[x + K / 2][y + i];
                }
            }

            return sum;
        }


        if (left) {
            for (int i = -K / 2; i < K / 2 + 1; i++) {
                if (isPossible(x + i, y - K / 2, xLen, yLen)) {
                    sum += image[x + i][y - K / 2];
                }

                if (isPossible(x + i, y + K / 2 + 1, xLen, yLen)) {
                    sum -= image[x + i][y + K / 2 + 1];
                }
            }
        } else {
            for (int i = -K / 2; i < K / 2 + 1; i++) {
                if (isPossible(x + i, y - K / 2 - 1, xLen, yLen)) {
                    sum -= image[x + i][y - K / 2 - 1];
                }

                if (isPossible(x + i, y + K / 2, xLen, yLen)) {
                    sum += image[x + i][y + K / 2];
                }
            }
        }


        return sum;
    }

    public static boolean isPossible(int x, int y, int xLen, int yLen) {    // x, y 값이 array 범위안에 있는지 체크
        return x >= 0 && y >= 0 && x < xLen && y < yLen;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 5, 2, 6, 7},
                {5, 4, 2, 4, 6},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}};

        int[][] result = solution(arr, 3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.printf("%d ", result[i][j]);
            }
            System.out.println();
        }
    }
}

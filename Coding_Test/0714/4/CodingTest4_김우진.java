package CodingTest8;

/**
 * 코딩 테스트 당시 14점
 *
 * 전형적인 격자 DP 문제
 * 1. 열쇠방 위치를 먼저 찾고 해당 좌표를 저장
 * 2. 시작점부터 열쇠방까지의 경우의 수를 찾고
 * 3. 열쇠방부터 도착점까지의 경우의 수를 찾고
 * 4. 2번에서 구한 값과 3번에서 구한 값의 곱을 반환
 *
 * cache 배열을 MAX * MAX로 초기화하는 과정에서 시간 초과가 발생한 것으로 추정
 * 이후 정답 코드는 제공된 정답 코드 참고하여 작성
 * 로직은 동일하며 한 가지 차이점은 cache 배열을 MAX * MAX로 선언하는 것이 아니라 적절하게 N * M으로 선언
 * 정답 코드는 dp 0-index, 제 코드의 cache 배열은 1-index
 */
public class CodingTest4_김우진 {
    public static int MOD = 1007;

    public static int MAX = 1000 + 1;

    public static int solution(int[][] maze) {
        int keyY = -1, keyX = -1;
        int N = maze.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maze[i][j] == 2) {
                    keyY = i + 1;
                    keyX = j + 1;

                    break;
                }
            }

            if (keyY != -1) {
                break;
            }
        }

        int[][] cache = new int[MAX][MAX];
        cache[0][1] = 1;

        for (int y = 1; y <= keyY; y++) {
            for (int x = 1; x <= keyX; x++) {
                if (maze[y - 1][x - 1] == 1) {
                    continue;
                }

                cache[y][x] = (cache[y][x] + cache[y - 1][x] + cache[y][x - 1]) % MOD;
            }
        }

        int waysToKeyCnt = cache[keyY][keyX];
        cache[keyY][keyX] = 1;

        for (int y = keyY; y <= N; y++) {
            for (int x = keyX; x <= N; x++) {
                if (y == keyY && x == keyX) {
                    continue;
                }

                if (maze[y - 1][x - 1] == 1) {
                    continue;
                }

                cache[y][x] = (cache[y][x] + cache[y - 1][x] + cache[y][x - 1]) % MOD;
            }
        }

        return waysToKeyCnt * cache[N][N] % MOD;
    }

    public static void main(String[] args) {
        int[][] maze = {{0 , 1, 0}, {0, 2, 0}, {1, 0, 0}};

        System.out.println(solution(maze));
    }
}
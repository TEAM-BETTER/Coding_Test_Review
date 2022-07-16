package CodingTest8;

/**
 * 코딩 테스트 당시 0점 후 제공된 정답 코드 보고 이해한 상태
 * N이 최대 10,000이고 제공된 코드처럼 dp 배열을 2 * N이 아닌 N * N으로 선언했기 떄문에 메모리 초과가 발생할 것이라고 생각
 * 또한, 접근 방식을 화석의 위치에서 depth가 0인 곳까지 가는 역순으로 생각하며 top-down 방식인 재귀함수를 사용했으나 시간초과 발생
 *
 * 코드 해석
 * 1. cache 배열을 2 * N으로 선언하는데 N이 아닌 2로 선언할 수 있는 이유는 depth를 한칸씩 내려가기 떄문에 이전 depth의 최소값만 알면 되기 때문
 * -> 즉, 현재 depth의 최소값을 알기 위해서는 (depth - 1)의 최소 값만 알면 됨
 * 2. 0번째 깊이에 대해서는 cache와 blocks 동일
 * 3. 깊이 [1, depth]에 대해 반복문을 돌며 { 좌상단, 상단, 우상단 }의 최솟값 + 현재 블록값을 cache에 업데이트
 * 4. cache[depth % 2][n]을 반환
 */

public class CodingTest2_김우진 {

    public static int solution(int depth, int n, int[][] blocks) {
        int N = blocks[0].length;
        int[][] cache = new int[2][N];

        for (int x = 0; x < N; x++) {
            cache[0][x] = blocks[0][x];
        }

        for (int y = 1; y <= depth; y++) {
            for (int x = 0; x < N; x++) {
                if (x == 0) {
                    cache[y % 2][x] = Math.min(cache[(y - 1) % 2][x], cache[(y - 1) % 2][x + 1]) + blocks[y][x];
                } else if (x == N - 1) {
                    cache[y % 2][x] = Math.min(cache[(y - 1) % 2][x - 1], cache[(y - 1) % 2][x]) + blocks[y][x];
                } else {
                    cache[y % 2][x] = Math.min(cache[(y - 1) % 2][x - 1], cache[(y - 1) % 2][x]);
                    cache[y % 2][x] = Math.min(cache[y % 2][x], cache[(y - 1) % 2][x + 1]) + blocks[y][x];
                }
            }
        }

        return cache[depth % 2][n];
    }

    public static void main(String[] args) {
        int depth = 3;
        int n = 3;
        int[][] blocks = {{5, 6, 2, 6}, {1, 6, 4, 9}, {5, 6, 9, 4}, {55, 14, 21, 14}};

        System.out.println(solution(depth, n, blocks));
    }
}
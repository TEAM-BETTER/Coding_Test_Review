package ch04.codingTest8.p2;

import java.util.Arrays;
import java.util.PriorityQueue;


// 이 문제도 점수가 잘 나오지 안았습니다
// 시작점을 땅 맨 위에서 시작하지 않고 목표지점에서 출발하여 퍼지는 방식을 택했습니다.
// DP를 사용하여 최소값을 업데이트해가며 depth, n 지점 부터 depth 가 0 이 되는 점에 도달하는 것을 기준으로 알고리즘을 작성하였습니다.
public class Solution {

    public static int solution(int depth, int n, int[][] blocks) {
        int answer = 0;
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[blocks.length][blocks[0].length];  // dp 배열

        for (int i = 0; i < blocks.length; i++) {               // dp 배열 초기화
            Arrays.fill(dp[i], INF);
        }
        dp[depth][n] = 0;                                       // dp 시작지점 0 으로
        cur(depth, n, blocks, dp);                              // dp 계산 메소드
        answer = Arrays.stream(dp[0]).min().getAsInt() + blocks[depth][n];      // depth 0 인 지점에서 가장 작은 값 찾기 + 목표지점 에너지 더해주기


        return answer;
    }

    public static void cur(int depth, int n, int[][] blocks, int[][] dp) {
        if (depth == 0) {                   // depth 가 0 이되면 종료
            return;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);    // 위쪽 depth 로 가는 3가지 중에 가장 작은 값부터 하기 위한 PQ
        for (int i = -1; i <= 1; i++) {
            if (isPossible(n - i, dp.length, dp[0].length)) {                    // 세가지 방향이 dp 사이즈 안에 있는지 확인하는 함수
                queue.add(new int[]{n - i, blocks[depth - 1][n - i]});              // 세가지 방향 PQ 에 추가
            }
        }

        while (!queue.isEmpty()) {                                                  // PQ 에 추가 한 값 순서대로 빼내면서 DP 업데이트
            int[] next = queue.poll();                                              // 다음 블럭을 가기위한 에너지, 좌표
            if (dp[depth - 1][next[0]] > dp[depth][n] + blocks[depth - 1][next[0]]) { // 다음 블럭으로 가는 에너지를 더했을 때 DP에 작성 된 값보다 작다면
                dp[depth - 1][next[0]] = dp[depth][n] + blocks[depth - 1][next[0]];   // DP 업데이트 후 그 위치에서 다시 cur 메소드 호출
                cur(depth - 1, next[0], blocks, dp);
            }
        }
    }

    public static boolean isPossible(int n, int len, int len2) {    // 좌표가 DP 사이즈 안에 있는지 확인하는 메소드
        return n < len2 && n >= 0;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{5, 6, 2, 6}, {1, 6, 4, 9}, {5, 6, 9, 4}, {55, 14, 21, 14}};
        System.out.println(solution(3, 3, a));

    }
}

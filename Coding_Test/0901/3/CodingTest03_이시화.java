package codiingTest.codingTest15.p3;


import java.util.Arrays;


// 2번 문제와 마찬가지로 브릍포스 말고는 생각이 나질 않습니다.
// 정확성은 모두 통과햐였지만 효율성에서 모두 시간초과를 받았습니다.
public class Solution {
    public static int solution(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len];                // 현재 자리에서 가질 수 있는 가장 큰 값 저장
        Arrays.fill(dp, Integer.MIN_VALUE);      // dp 초기화
        dp[0] = arr[0];

        for (int i = 0; i < len; i++) {         // arr 모든 변수 돌기
            for (int j = 1; j <= k; j++) {      // i 자리에서 k만큼 갈 수 있는 곳 dp에 업데이트
                if (i + j >= len) {
                    break;
                }
                dp[i + j] = Math.max(dp[i + j], dp[i] + arr[i + j]);
            }
        }


        return dp[len - 1];                     // dp 에 기록된 마지막 값 리턴
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, -4, 5, 1, 3, -5, -12, 4, -4, 5};
        System.out.println(solution(a, 3));

    }
}

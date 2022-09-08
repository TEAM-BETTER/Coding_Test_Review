package codiingTest.codingTest15.p5;


// 생각보다 쉬웠던 문제
// 부르트포스로 돌렸지만 효율적인 부분을 조금 개선해주어 통과
// 처음 0 ~ n-1 개를 제외하였을 때 부터 시작하여 2 * n ~ 맨 끝을 제외하였을 떄 까지 부르트포스로 계산
public class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        int n3 = nums.length;       // 배열 총 길이
        int n = n3 / 3;             // 배열 길이의 1/3 길이
        int n2 = 2 * n;             // 배열 길이의 2/3 길이
        int fistSum = 0;             // 첫 n 개의 합
        int secondSum = 0;          // 두번째 n 개의 합

        for (int i = n; i < n2; i++) {  // 0 ~ n-1 개 를 제외하였을 때 firstSum 게산
            fistSum += nums[i];
        }

        for (int i = n2; i < n3; i++) { // 0 ~ n-1 개 를 제외하였을 때 secondSum 게산
            secondSum += nums[i];
        }

        answer = fistSum - secondSum;

        for (int i = 0; i < n; i++) {       // 제외 값을 (0 ~ n-1)에서 (n ~ 2n) 까지 돌림
            fistSum += nums[i];              // 이떄는 fistSum 의 값만 변하기 때문에
            fistSum -= nums[n + i];          // 처음에 계산한 firstSum 에서 더해지는 index 하나와 빠져나가는 index 하나만 계산
            answer = Math.min(answer, fistSum - secondSum);
        }

        for (int i = n; i < n2; i++) {      // 제외 값을 (n ~ 2n)에서 (2n ~ 3n) 까지 돌림
            secondSum += nums[i];           // 이떄는 secondSum 의 값만 변함
            secondSum -= nums[n2 + i - n];
//        firstSum 과 secondSum 이 변할 때마다 answer 에 최소 값 업데이트
            answer = Math.min(answer, fistSum - secondSum);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 9, 5, 8, 1, 3};
        System.out.println(solution(a));
    }
}



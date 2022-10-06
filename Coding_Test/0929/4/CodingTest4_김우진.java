package CodingTest19;

import java.util.Arrays;

public class CodingTest4_김우진 {

    /**
     * 배열 param0 의 모든 값을 절대값으로 바꿔주고 정렬
     * tmp = param0[i-1]
     * param0 배열 돌면서 param0[i]과 tmp가 같으면 쌍이 됨
     * answer는 쌍이 되는 큰 값을 계속 업데이트
     */

    public static int solution(int[] param0) {
        int answer = 0;

        for (int i = 1; i < param0.length; i++) {
            param0[i] = Math.abs(param0[i]);
        }

        Arrays.sort(param0);

        int tmp = param0[0];

        for (int i = 1; i < param0.length; i++) {
            if (param0[i] == tmp) {
                answer = Math.max(answer, tmp);
            }
            tmp = param0[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, -2, 5, -3};
        System.out.println(solution(nums));
    }
}
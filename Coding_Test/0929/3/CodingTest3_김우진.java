package CodingTest19;

import java.util.Arrays;

public class CodingTest3_김우진 {

    /**
     * param0 배열을 정렬 후, 배열 중 가장 큰 숫자를 N으로 지정
     * -> boolean배열의 길이는 N
     *
     * param0 배열에 있는 숫자를 boolean 배열의 idx에 true로 표시
     *
     * false 갯수 카운트 후 answer 리턴
     */

    public static int solution(int[] param0) {
        Arrays.sort(param0);

        int N = param0[param0.length - 1] + 1;
        boolean[] isNotEmpty = new boolean[N];

        for (int x : param0) {
            isNotEmpty[x] = true;
        }

        int answer = 0;

        for (int i = 1; i < N; i++) {
            if (isNotEmpty[i] == false) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution(nums));
    }
}
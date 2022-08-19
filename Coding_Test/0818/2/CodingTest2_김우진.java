package CodingTest13;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 정확성 : 10점 / 효율성 : 4점 (시간 초과(2,5) 및 메모리 초과(4))
 *      3중포문으로 풀었기 때문에 시간 및 메모리 초과가 날 것이라 예상했습니다.
 *      투포인터로 풀어볼까 했는데 런타임에러로 10점 나왔고 최종 정답처리는 아래 답안이 되었습니다
 *      주말에 다시 풀어보고 답안 올리겠습니다
 *
 * 1. 3개의 수를 3중 포문으로 돌려 나온 값은 ArrayList에 넣음
 *      여기서 target과 같은 값 발견 시, 리턴
 *
 * 2. ArrayList의 숫자들과 target의 차이값 구한 후
 *      가장 작은 차이값을 더하거나 뺀 숫자 중에
 *      ArrayList에 있는 값으로 리턴
 *
 */

public class CodingTest2_김우진 {

    public static int solution(int[] arr, int target) {
        int answer = 0;
        ArrayList<Integer> arrClone = new ArrayList<>();
        Arrays.sort(arr);
        int abs = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    arrClone.add(sum);
                    abs = Math.min(Math.abs(sum - target), abs);

                    if (sum == target) {
                        return sum;
                    }
                }
            }
        }

        if (arrClone.contains(target - abs)) {
            answer = target - abs;
        } else if (arrClone.contains(target + abs)) {
            answer = target + abs;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 15, 3, 10, 12};
        int target = 21;

        System.out.println(solution(arr, target));
    }
}
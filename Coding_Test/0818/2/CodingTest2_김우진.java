package CodingTest13;

import java.util.Arrays;

/**
 * 1. 초기 숫자 3개 : arr[i], arr[i+1], arr[arr.length-1]
 *      arr[i]는 고정으로 두고 (i + 1)과 (arr.length - 1)가 투 포인터
 *
 * 2. haveToUpdate 메서드 : 현재 sum을 answer로 업데이트할지 여부를 판단하는 메서드
 *
 * 3. 투포인터로 target값을 탐색, 찾으면 반복 종료,
 *      현재 sum이 target 값보다 작을 경우 sum을 증가시켜야하므로 left++
 *      현재 sum이 target 값보다 클 경우 sum을 감소시켜야하므로 right--
 *      현재 sum이 target이면 답이므로 바로 target 반환

 ** 없으면 시간초과1 : arr[i] == arr[i - 1]
 *      어차피 같은 값이기 때문에 계산하지말고 다음으로 넘어가는게 시간 줄이기
 *
 *** 없으면 시간초과2: target값을 찾으면 더 이상 탐색할 필요가 없음
 *
 */

public class CodingTest2 {
    static boolean haveToUpdate(int answer, int sum, int target) {
        if (Math.abs(target - answer) == Math.abs(target - sum)) {
            return answer > sum;
        }

        return Math.abs(target - answer) > Math.abs(sum - target);
    }

    public static int solution(int[] arr, int target) {
        Arrays.sort(arr);
        int answer = 100000000 + 30001;

        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            //없으면 시간초과 1
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (haveToUpdate(answer, sum, target)) {
                    answer = sum;
                }

                //없으면 시간초과 2
                if (sum == target) {
                    return target;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 15, 3, 10, 12};
        int target = 21;

        System.out.println(solution(arr, target));
    }
}

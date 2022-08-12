package CodingTest12;

import java.util.Arrays;

/**
 * 정확성 : 10 / 효율성 : 6 (시간초과 :4,5 )
 *
 * 1. arr 배열에서 k보다 적게 배열 순회
 * 2. tmpArr 배열에 k만큼 값 입력 후 정렬
 * 3. 정렬 된 배열에서 중앙값을 answer 에 쌓아줌
 *
 * ** 입력값이  0 < len(arr) <= 10000 범위라서 시간초과 날 줄 알았지만
 *      pq나 list 로 풀었을때는 3번까지 시간초과가 나서 배열로 마무리했습니다
 *
 * **   강사님 코드를 보니 heap 을 두번 쓰는게 정석인가 봅니다.
 *      https://www.youtube.com/watch?app=desktop&v=NT5Lp5vaMm0
 *      주말에 공부 해보겠습니다
 *
 */

public class CodingTest4_김우진 {

    public static int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length - k + 1];
        int[] tmpArr = new int[k];

        for (int i = 0; i <= arr.length - k; i++) {
            int idx = 0;

            for (int j = i; j < k + i; j++) {
                tmpArr[idx] = arr[j];
                idx++;
            }
            Arrays.sort(tmpArr);

            answer[i] = tmpArr[k / 2];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 4, 10, 15, 16, 15, 17};
        int k = 5;
        System.out.println(Arrays.toString(solution(arr, k)));
    }
}

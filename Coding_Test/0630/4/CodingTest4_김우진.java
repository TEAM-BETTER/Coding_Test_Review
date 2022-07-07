package CodingTest6;
/**
 * 1. 슬라이딩윈도우는 0부터 k의 값에서 최댓값을 구한 후 배열 탐색 시작
 * 2. 덱에 들어온 배열 값 중 최대값을 가지는 인덱스가 덱의 제일 앞 부분에 오게함
 * 해당 인덱스에 매칭되는 배열 값을 answer 배열에 넣어줌
 * 3. 윈도우를 다음으로 슬라이딩하면서 가장 최대값이었던 덱의 앞부분이
 * 없어지는 값 즉, 슬라이딩하면서 더 이상 트래킹하지 않은 인덱스일 경우 덱 앞부분 삭제
 * 4. 그리고 윈도우를 슬라이딩하면서 들어오는 새로운 값을 덱에 넣어줌
 * 2-4 루틴 반복하면서 answer배열 완성 후 리턴
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class CodingTest4_김우진 {

    public static void slideWindow(int i, int k, Deque<Integer> dq, int[] arr) {
        // 현재 최대값이 윈도우를 슬라이드했을 때 없어지는 인덱스라면 덱에서 제거
        if (!dq.isEmpty() && dq.getFirst() == i - k) {
            dq.removeFirst();
        }

        // 덱의 제일 앞부분이 최댓값이 되도록 while문 돌림
        while (!dq.isEmpty() && arr[i] > arr[dq.getLast()]) {
            dq.removeLast();
        }

        // 덱의 마지막에 윈도우를 슬라이드했을 때 처음 인덱스를 넣어줌
        dq.addLast(i);
    }

    public static int[] solution(int[] arr, int k) {
        // 기저 사례: k가 1이면 그대로 반환
        if (k == 1) {
            return arr;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int[] answer = new int[arr.length - k + 1];
        int maxIdx = 0;

        /**
         * [0, k] 구간 최대값을 구하고
         */
        for (int i = 0; i < k; i++) {
            slideWindow(i, k, dq, arr);

            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }

        answer[0] = arr[maxIdx];

        for (int i = k; i < arr.length; i++) {
            slideWindow(i, k, dq, arr);

            answer[i - k + 1] = arr[dq.getFirst()];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 4, 2, 3};
        int k = 3;

        int[] answer = solution(arr, k);

        for (int a : answer) {
            System.out.print(a + " ");
        }

        System.out.println();
    }
}
package CodingTest7;
import java.util.ArrayDeque;
import java.util.Deque;

public class CodingTest5_김우진 {

    public static int solution(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스를 넣어줄 스택
        int[] pSum = new int[nums.length + 1];

        /**
         * 부분합을 구하고
         * 부분합은 1-index (0-index가 아님)
         */
        for (int i = 0; i < nums.length; i++) {
            pSum[i + 1] = pSum[i] + nums[i];
        }

        int answer = 0;

        /**
         * i를 nums.length 이하까지 하는 이유는 마지막 구간까지 확인하기 위해
         * stack에는 항상 해당 구간의 최솟값을 가리키는 인덱스가 peek로 존재
         */
        for (int i = 0; i <= nums.length; i++) {
            /**
             * 스택이 비어있지 않고
             * a) 인덱스가 nums 마지막까지 왔거나
             * b) 다음에 넣어줄 수가 현재 구간 최댓값보다 작을 때
             *
             * 단조 감소 수열일 때 answer가 최대라는 가정으로 진행
             */
            while (!stack.isEmpty()
                    && (i == nums.length || nums[stack.peek()] > nums[i])) {
                int minValue = nums[stack.pop()];
                int sum = stack.isEmpty() ? pSum[i] : pSum[i] - pSum[stack.peek() + 1];

                answer = Math.max(answer, minValue * sum);
            }

            stack.push(i);
        }

        return answer;
    }
}

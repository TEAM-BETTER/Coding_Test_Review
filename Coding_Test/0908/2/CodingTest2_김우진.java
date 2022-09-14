package CodingTest16;

import java.util.Collections;
import java.util.PriorityQueue;

public class CodingTest2_김우진 {

    /**
     * minHeap : 오름차순 정렬 // maxHeap : 내림차순 정렬
     * minFirstSum 배열 : firstSum의 값을 저장해두는 배열
     *
     * firstSum의 범위는 nums 배열의 0 ~ (N * 2) -1까지
     * maxHeap에 firstSum의 후보값인 nums[i]을 넣어주고, firstSum에 nums[i]를 더해줌
     *      -> 만약 maxHeap.size가 N보다 커지면 firstSum에서 내림차순 정렬 되었던 maxHeap중 최대 값 빼기
     *      -> maxHeap.size가 N과 같아지면 firstSum의 값을 minFirstSum[i]에 넣어줌
     *
     * secondSum의 범위는 nums 배열의 N ~ len-1까지
     *      -> 만약 minHeap.size가 N보다 커지면 secondSum에서 오름차순 정렬 되었던 minHeap중 최소 값 빼기
     *      -> minHeap.size가 N과 같아지면
     *      answer에 minFirstSum[i-1]에서 secondSum을 뺀 값과 answer중 작은 값을 answer에 업데이트
     */

    public static int solution(int[] nums) {
        int len = nums.length;
        int N = len / 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int[] minFirstSum = new int[len];
        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < 2 * N; i++) {
            maxHeap.add(nums[i]);
            firstSum += nums[i];

            if (maxHeap.size() > N) {
                firstSum -= maxHeap.poll();
            }

            if (maxHeap.size() == N) {
                minFirstSum[i] = firstSum;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = len - 1; i >= N; i--) {
            minHeap.add(nums[i]);
            secondSum += nums[i];

            if (minHeap.size() > N) {
                secondSum -= minHeap.poll();
            }
            if (minHeap.size() == N) {
                answer = Math.min(answer, minFirstSum[i - 1] - secondSum);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {7, 9, 1, 5, 8, 3};
        System.out.println(solution(nums));
    }
}
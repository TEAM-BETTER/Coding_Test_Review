/*
우연히 릿코드에서 풀었던 문제여서 금방 풀 수 있었던 문제였습니다.
우선순위 큐를 이용한 방식입니다!
 */
import java.util.*;
public class Solution {
    public static int[] solution(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();  // 값이 큰 기준으로 정렬됩니다.
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Number(i, nums[i]));             // 우선순위 큐에 인덱스와 값을 넣어줍니다.
            if (i - k + 1 < 0) continue;
            while (pq.peek().index <= i - k) {          // 첫번째 Number의 인덱스가 슬라이딩 윈도우를 벗어나면 값을 poll시킵니다.
                pq.poll();
            }
            result.add(pq.peek().num);
        }

        int[] answer = new int[result.size()];
        int index = 0;
        for (int num : result) {
            answer[index++] = num;
        }
        return answer;
    }

    static class Number implements Comparable<Number> {
        int index, num;
        Number(int index, int num) {
            this.index = index;
            this.num = num;
        }
        @Override
        public int compareTo(Number number) {
            return number.num - this.num;
        }
    }
}
package codiingTest.codingTest12.p4;

import java.util.*;

// priorityQueue 를 두개 만들어서 하나는 max heep  하나는 min heep 으로구성
// k 개의 숫자 만큼 min heep pQ에 넣고 max heep 과 min heep 의 사이즈 차이가 1일 때까지 옮겨줌
// 이후 한칸식 슬라이딩 윈도우처럼 움직일 때 없어지는 항목을  queue 의 remove 를 통해 제거하고
// 더 해지는 항목을 이전 중간값과 비교해 min / max heep 에 더해줌
// 그 후 다시 min / max heep 의 size 차이가 1 이 될떄까지 큰 쪽에서 작은 쪽으로 옮겨줌
// size 차이가 1이 되면 큰쪽의 pQ에서 peek - > mid 값
// 그 값을 answer 에 추가하고 반복
public class Solution {
    public static PriorityQueue<Integer> queueMax;
    public static PriorityQueue<Integer> queueMin;

    public static int[] solution(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();
        queueMax = new PriorityQueue<>(Collections.reverseOrder());
        queueMin = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queueMin.add(arr[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            queueMax.add(queueMin.poll());
        }
        answer.add(queueMin.peek());

        for (int i = k; i < arr.length; i++) {
            answer.add(culMid(arr[i], arr[i - k], answer.get(answer.size() - 1)));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int culMid(int num, int before, int mid) {
        if (mid < num) {
            queueMin.add(num);
        } else {
            queueMax.add(num);
        }

        if (queueMax.size() > queueMin.size()) {
            if (!queueMax.remove(before)) {
                queueMin.remove(before);
            }
        } else {
            if (!queueMin.remove(before)) {
                queueMax.remove(before);
            }
        }

        while (Math.abs(queueMax.size() - queueMin.size()) != 1) {
            if (queueMax.size() > queueMin.size()) {
                queueMin.add(queueMax.poll());
            } else {
                queueMax.add(queueMin.poll());
            }
        }

        return queueMin.size() > queueMax.size() ? queueMin.peek() : queueMax.peek();
    }
}


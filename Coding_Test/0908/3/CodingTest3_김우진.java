package CodingTest16;

import java.util.*;

public class CodingTest3_김우진 {

    /**
     * getSum = 자릿수 마다 더한 값 구하는 메서드
     *
     * Map <자릿수를 더한 합, key에 맞는 nums 배열의 PriorityQueue >
     *   -> 최대 자릿수 합은 9+9+9+9 = 36으로 0부터 36까지 키 초기화
     * candidates : set으로 중복 없이 map에서의 key값을 후보에 올려둠
     *
     * nums 배열 안의 숫자를 확인
     *      -> getSum을 통해 자릿수 더한 값 확인
     *      -> map에 sum에 해당하는 키 값을 찾아 value에 num을 넣어줌
     *      -> candidates 에 해당 sum 값 추가
     *
     * candidates에 쌓인 키 값 기준 2개 미만이면 다음 키 값 확인 ,
     *  2개 이상이면 오름차순 정렬 되어 있던 맨 처음과 그 다음 값 더해줌
     *  answer에는 더한 값 중 가장 높은 값으로 더한 키 값을 업데이트
     *
     * 만약 쌍이 없었으면 answer의 초기값 -1 리턴,
     * 업데이트 된 값이 있었다면 해당 answer값 리턴
     *
     */

    static int getSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int solution(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        Set<Integer> candidates = new HashSet<>();

        for (int i = 0; i <= 36; i++) {
            map.put(i, new PriorityQueue<>(Collections.reverseOrder()));
        }

        for (int num : nums) {
            int sum = getSum(num);

            map.get(sum).add(num);
            candidates.add(sum);
        }

        int answer = -1;

        for (int candidate : candidates) {
            if (map.get(candidate).size() < 2) {
                continue;
            }

            PriorityQueue<Integer> pq = map.get(candidate);
            answer = Math.max(answer, pq.poll() + pq.poll());
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {18, 36, 72, 16, 52};

        System.out.println(solution(nums));
    }
}
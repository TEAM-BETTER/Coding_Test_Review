package CodingTest6;
/**
 *  그리디로 접근합니다
 *  먼저 class로 Meat의 amount와 value를 정의?한다
 *  총 섭취가능한 양과 가장 적게 먹는 사람의 양을 체크.
 *  고기는 비싼고기 순으로 먹어야 value의 최대값을 구할 수 있으므로 그리디하게 접근해야한다.
 *  가장 비싼 고기는 함께, 같은 양으로 섭취해야 하기 때문에
 *  비싼고기의 양을 나누었을때, 모두 먹을 수 있게 나누어진다면
 *  동일하게 나누어진 비싼 고기의 value * 모두 먹을 수 있게 나누어진 몫 을 구해서
 *  answer에 더해줌
 *  그 이후부터는 그리디하게 비싼고기 순으로 현재 먹을 수 있는 양을 계산 후
 *  남은 전체 포화도(stomachSum)에서 먹을 수 있는 양을 빼줌
 *  그리고 answer에 (먹은 고기 양 * 먹은 고기 값)만큼 더해줌
 *  고기를 다 먹거나 더 먹을 수 없어 질 때까지 반복
 *  반복문을 통해 구해진 answer값 return
 *
 */

import java.util.ArrayList;
import java.util.List;

public class CodingTest2_김우진 {

    public static class Meat {

        private int amount;

        private int value;

        public Meat(int amount, int value) {
            this.amount = amount;
            this.value = value;
        }

        public int getAmount() {
            return amount;
        }

        public int getValue() {
            return value;
        }
    }

    public static int solution(int[] amount, int[] value, int[] stomach) {
        int stomachSum = 0;
        int minStomach = Integer.MAX_VALUE;

        // 섭취 가능한 양 파악
        for (int capa : stomach) {
            stomachSum += capa;

            minStomach = Math.min(minStomach, capa);
        }

        List<Meat> meats = new ArrayList<>();

        for (int i = 0; i < amount.length; i++) {
            meats.add(new Meat(amount[i], value[i]));
        }

        // 비싼 순서대로 고기를 정렬
        meats.sort((o1, o2) -> o2.value - o1.value);

        /**
         * 문제조건: 가장 가치가 높은 고기는 친구들끼리 공평하게 같은 양을 먹어야함
         * 즉, 가장 가치가 높은 고기의 양이 친구들의 수 이상이면 공평하게 최소 1씩 나눠먹을 수 있음
         */
        boolean sameAmount = true;
        Meat mostExpensive = meats.get(0);

        if (mostExpensive.amount < stomach.length) {
            sameAmount = false;
        }

        int answer = 0;

        /**
         * 만약 공평하게 나눠먹을 수 있으면
         * 공평하게 나눠먹은 만큼 먹을 수 있는 양에서 차감하고
         * 먹은 양만큼의 가치를 증가시킴
         */
        if (sameAmount) {
            int mostExpensiveAmount = Math.min((mostExpensive.amount / stomach.length) * stomach.length, minStomach * stomach.length);
            stomachSum -= mostExpensiveAmount;
            answer += mostExpensiveAmount * mostExpensive.getValue();
        }

        /**
         * 두 번째로 비싼 고기부터 순서대로 먹임
         * stomachSum이 0이 되는 순간 멈추고 answer 출력
         */
        for (int i = 1; i < meats.size() && stomachSum > 0; i++) {
            if (stomachSum - meats.get(i).getAmount() >= 0) {
                answer += meats.get(i).getAmount() * meats.get(i).getValue();
                stomachSum -= meats.get(i).getAmount();
            } else {
                answer += stomachSum * meats.get(i).getValue();
                stomachSum = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] amount = {7, 10, 4, 5};
        int[] value = {5, 4, 3, 1};
        int[] stomach = {4, 6, 2, 8};

        System.out.println(solution(amount, value, stomach));
    }
}
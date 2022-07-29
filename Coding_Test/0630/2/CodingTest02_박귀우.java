// 큐안에 고기를 넣어서 value 순으로 뽑습니다.
// 만약 동일한 값어치의 고기가 있다면 그 값어치가 없어질떄 까지 뽑습니다.

import java.util.*;

public class CodingTest02_박귀우 {
    public int solution(int[] amount, int[] value, int[] stomach) {
        int answer = 0;
        PriorityQueue<Meet> q = new PriorityQueue<>();
        for (int i = 0; i < amount.length; i++) {
            q.offer(new Meet(amount[i], value[i]));
        }

        int total = Arrays.stream(stomach).sum(); // 총합을 구해서 여기서 부터 빼나가면됩니다.
        int people = stomach.length; // 사람수 를 많이 사용할꺼 같아서 변수로 지정했습니다.
        boolean isFirst = true; // 제일비싼 고기 의 경우 특수한케이스 이니 따로 뺏습니다.

        while (total > 0 && !q.isEmpty()) {
            ArrayList<Meet> m = new ArrayList<>(); // 동일한 값어치 의 고기를 닮을 리스트 입니다.
            m.add(q.poll());
            while (isFirst && !q.isEmpty() && m.get(m.size() - 1).value == q.peek().value) {
                m.add(q.poll());
            }
            if (isFirst) { // 지금이 첫번쨰 라면 특별한 조건으로 처리해줍니다.
                int currentAmount = 0;
                int currentValue = 0;
                for (int i = 0; i < m.size(); i++) { // 동일한 값어치의 고기의 값만큼 돌리면서 모두 가져옵니다.
                    currentAmount += m.get(i).amount;
                    currentValue = m.get(i).value;
                }
                if (currentAmount < people) { // 만약 현재값 이 사람의 수보다 작다면 모두 버려줍니다.
                    isFirst = false;
                    continue;
                }
                if (currentAmount > total) { // 현재의값, 먹을수 있는 총양 보다 많다면 함수를 종료 하고 답을 업데이트합니다.
                    answer += total * currentValue;
                    total = 0;
                } else { // 위의경우가 아닌경우
                    int canEat = currentAmount / people;
                    answer += canEat * currentValue * people;
                    total -= canEat * people;
                }
                isFirst = false;
            } else {
                int currentAmount = 0;
                int currentValue = 0;
                for (int i = 0; i < m.size(); i++) {
                    currentAmount += m.get(i).amount;
                    currentValue = m.get(i).value;
                }
                if (currentAmount > total) { // 현재의 양이 총량을 넘는 경우 반복문의 탈출을 위해 total 을 업데이트 합니다.
                    answer += total * currentValue;
                    total = 0;
                } else { // 그경우가 아닌경우 다음으로 while 로 넘어갑니다.
                    answer += currentAmount * currentValue;
                    total -= currentAmount;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}

class Meet implements Comparable<Meet> {
    int value;
    int amount;

    Meet(int amount, int value) {
        this.value = value;
        this.amount = amount;
    }

    @Override
    public int compareTo(Meet o) {
        return o.value - this.value;
    }
}

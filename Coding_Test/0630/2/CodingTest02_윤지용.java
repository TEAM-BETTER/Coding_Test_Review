import java.util.PriorityQueue;

public class CodingTest02_윤지용 {
    static class Meat {
        int amount;
        int value;
        Meat() {};
        Meat(int amount, int value) {
            this.amount = amount;
            this.value = value;
        }
    }

    public static int solution(int[] amount, int[] value, int[] stomach) {
        int answer = 0;
        PriorityQueue<Meat> pq = new PriorityQueue<>((Meat m1, Meat m2) -> m1.value >= m2.value ? -1 : 1);

        for (int i = 0; i < amount.length; i++) {
            pq.add(new Meat(amount[i], value[i]));
        }

        int sum_stoma = 0; // 총 먹을 수 있는 양
        int min_stoma = Integer.MAX_VALUE; // 제일 조금먹는 양 -> 비싼거 먹을 수 있는 최대 양

        for (int i = 0; i < stomach.length; i++) {
            sum_stoma += stomach[i]; // 총 먹는 양 계산
            if(stomach[i] < min_stoma) {
                min_stoma = stomach[i]; // 제일 조금 먹는 사람 양 체크
            }
        }

        Meat cur = pq.poll(); // 비싼 고기 하나 찍어
        while(!pq.isEmpty() && cur.value == pq.peek().value) { // 같은 값의 비싼고기 중
            if(pq.peek().amount > cur.amount) { // 지금거보다 양이 많은거 찍어
                cur = pq.poll();
            } else {
                pq.poll(); // 아니면 버려
            }
        }

        if(cur.amount >= stomach.length) { // 사람 수 보다 양이 많으면
            int eat_amount_per = cur.amount / stomach.length; // 사람당 먹을 수 있는 고기 양
            int eat_amount_cur = (Math.min(eat_amount_per, min_stoma) * stomach.length);
            sum_stoma -= eat_amount_cur; // 제일 조금먹는 애랑 비교해서 작은 수만큼 먹어
            answer += eat_amount_cur * cur.value; // 가격 지불
        }

        while(sum_stoma > 0) { // 아직 먹을 수 있다면
            if(!pq.isEmpty()) { // 먹을 고기가 있다면
                cur = pq.peek(); // 다음 비싼고기
                if (sum_stoma >= cur.amount) { // 배에 여유 있으면
                    sum_stoma -= cur.amount; // 다 먹어
                    answer += cur.amount * cur.value; // 가격 지불
                    pq.poll();
                    continue;
                }
            } else { // 먹을 고기 없으면
                break;
            }

            if(sum_stoma < cur.amount) { // 이번 고기는 다 못먹으면
                answer += sum_stoma * cur.value; // 먹을 수 있는 만큼만 먹어치워
                break;
            }
        }
        return answer;
    }
    public static void main(String args[]) {
        int[] amount = {7, 10, 4, 5};
        int[] value = {5, 4, 3, 1};
        int[] stomach = {4, 6, 2, 8};
        System.out.println(solution(amount, value, stomach));
    }
}

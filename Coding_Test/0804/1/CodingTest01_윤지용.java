import java.util.*;

/*
아이디어
우선순위 큐 -> 트리맵 -> 큐 반복하면서 숫자 갯수 세기
마지막에 숫자로 변환하기
 */
public class CodingTest01_윤지용 {
    public static long solution(int n, int num) {
        long answer = 0;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 맨 처음 숫자 큐에 넣기
        while(num > 0) {
            int tmp = num % 10;
            pq.add(tmp);
            num = num / 10;
        }
        // 반복 횟수만큼 큐 -> 트리맵 -> 큐 반복
        for (int i = 0; i < n - 1; i++) {
            while(!pq.isEmpty()) {
                int cur = pq.poll();
                tm.put(cur, tm.getOrDefault(cur, 0) + 1);
            }

            tm.forEach((key, value) -> {
                pq.add(key);
                pq.add(value);
            });
            tm.clear(); // 다음을 위해 트리맵 초기화
        }
        // 마지막 결과값이 들어있는것 큐 -> 트리
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            tm.put(cur, tm.getOrDefault(cur, 0) + 1);
        }
        // 트리맵에서 순서대로 뺄때 리스트에 담아주고
        ArrayList<Integer> answerList = new ArrayList<>();
        tm.forEach((key, value) -> {
            answerList.add(key);
            answerList.add(value);
        });
        // 리스트에 있는것 int형 숫자로 바꿔주기
        for (int i = 0; i < answerList.size(); i++) {
            answer += answerList.get(i);
            answer = answer * 10;
        }
        return (answer / 10) % 10004; // 마지막에 자리수가 하나 더 올라가있는 상태라 10으로 나눈 후 10004 작업
    }


    public static void main(String[] args) {
        int n = 3;
        int num = 54223;
        System.out.println(solution(n, num));
    }
}

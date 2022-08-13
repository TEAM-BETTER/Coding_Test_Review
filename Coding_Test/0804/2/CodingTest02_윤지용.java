import java.util.PriorityQueue;

// 정확성 10 / 10 , 효율성 2 / 10 나왔습니다. (효율성에서 다 시간초과났네요)
/*
아이디어
사전식 배열이라 숫자를 문자로 바꿔 우선순위큐에서 정렬
빼면서 배열에 넣기
 */

public class CodingTest02_윤지용 {
    public static int[] solution(int n) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            pq.add(Integer.toString(i));
        }

        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx++] = Integer.parseInt(pq.poll());
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        solution(n);
    }
}

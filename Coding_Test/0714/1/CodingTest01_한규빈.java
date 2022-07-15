package CodingTest1;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 정확성 6점, 효율성 0점
// 문제 난이도 이지가 이지답지 않게 느껴지는 문제였습니다 ㅜㅜ
// 이 문제는 시간 정렬 없이 어떻게 풀어야 하는지 생각이 안 나서 일단 우선순위 큐로 정렬하고 시작했습니다. 정렬 없이 풀 수 있는 방법이 있는지 정말 많이 고민한 거 같아요
// 정렬 없이 풀 수 있는 방법이 있으면 어떤 식으로 접근해서 풀어야 하는지 코멘트 좀 남겨주시면 감사하겠습니다.
// 기존에는 return dp[length - 1]을 해줬는데 두 번째 for loop 끝나고 max 값을 업데이트해주고 return answer로 바꾸면 통과될 거 같기도 해서 토요일에 재도전 해보겠습니다.

// 상담 끝나는 시간이 빠른 순으로 우선순위 큐에 저장 만약 끝나는 시간이 같다면 시작 시간이 빠른 순으로 저장


public class CodingTest01_한규빈 {
    class Advice implements Comparable<Advice> {
        int start;
        int end;
        int price;

        public Advice(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Advice o) {
            if (o.end == this.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }

    public int solution(int[] start, int[] end, int[] price) {
//        int answer = Integer.MIN_VALUE;
        PriorityQueue<Advice> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < start.length; i++) {
            priorityQueue.offer(new Advice(start[i], end[i], price[i]));
        }

        // 정렬한 데이터를 리스트에 담기
        List<Advice> arrayList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            arrayList.add(priorityQueue.poll());
        }

        int length = arrayList.size();
        int[] dp = new int[length];

        // 정렬한 데이터 중 가장 첫번째 상담 가격을 저장
        dp[0] = arrayList.get(0).price;
        for (int i = 1; i < length; i++) {
            // 현재 위치부터 처음 위치까지 시작 시간과 끝나는 시간이 겹치지 않는 경우 상담 가격을 업데이트
            dp[i] = arrayList.get(i).price;
            for (int j = i - 1; j >= 0; j--) {
                if (arrayList.get(i).start >= arrayList.get(j).end) {
                    dp[i] = Math.max(dp[j] + arrayList.get(i).price, dp[i]);
                }
            }

//            answer = Math.max(answer, dp[i]);
        }

        return dp[length - 1];
//        return answer;
    }

    public static void main(String[] args) {
        int[] start = {1, 5, 10, 6, 5};
        int[] end = {5, 6, 12, 9, 12};
        int[] price = {10, 40, 30, 20, 50};
//        System.out.println(solution(start, end, price));

        start = new int[]{1, 2, 5, 1, 4 ,11};
        end = new int[]{10, 9, 6, 3, 9, 15};
        price = new int[]{50, 20, 50, 20, 80 ,40};
//        System.out.println(solution(start, end, price));
    }
}

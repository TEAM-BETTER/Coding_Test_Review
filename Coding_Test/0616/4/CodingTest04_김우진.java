package CodingTest4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1. Work의 우선순위를 정하기 위한 class선언
 *      start: 작업이 시작하는 시간 // idx: 작업의 고유 인덱스 // duration: 작업처리에 있어 소요되는 시간
 * 2. duration이 짧은 작업이 우선순위 높음, duration이 동일하다면 idx가 작은 쪽이 우선순위 높음
 * 3. Work 타입의 list에 start와 time 배열의 정보들을 전처리하여 Work 클래스를 넣어줌
 * 4. list에 정리된 데이터를 시작시간을 기준으로 오름차순 정렬
 * 5. Work 타입 PriorityQueue 선언, answer의 배열길이는 start 배열길이,
 *      시작 시간은 4번에서 구한 list의 첫 번째 작업의 시작시간
 * 6. answer의 배열을 다 채울 때까지 while문 진행
 *      현재 시간 t보다 시작시간이 앞서거나 같은 작업들을 5번에 선언해준 우선순위 큐에 넣어줌
 *      우선순위 큐가 비어있지 않다면 가장 우선순위가 높은 작업을 answer 배열에 넣어주고 시간을 해당 작업의 duration만큼 추가
 *      우선순위 큐가 비어있다면 list의 다음 작업 시작시간으로 시간을 이동
 *      해당 과정을 answer의 배열을 다 채울 떄까지 진행
 * */

class CodingTest04_김우진 {
    public static class Work implements Comparable<Work> {

        private int start;

        private int idx;

        private int duration;

        public Work(int start, int idx, int duration) {
            this.start = start;
            this.idx = idx;
            this.duration = duration;
        }

        public int getStart() {
            return start;
        }

        public int getIdx() {
            return idx;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public int compareTo(Work o) {
            if (this.duration < o.duration) {
                return -1;
            } else if (this.duration > o.duration) {
                return 1;
            }

            return this.idx - o.idx;
        }
    }

    public static int[] solution(int[] start, int[] time) {
        List<Work> list = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            list.add(new Work(start[i], i, time[i]));
        }

        list.sort((o1, o2) -> o1.start - o2.start);

        PriorityQueue<Work> pq = new PriorityQueue<>();
        int[] answer = new int[start.length];
        int answerIdx = 0;
        int startIdx = 0;
        int t = list.get(0).getStart();

        while (answerIdx != start.length) {

            while (startIdx != start.length && list.get(startIdx).getStart() <= t) {
                pq.add(new Work(t
                        , list.get(startIdx).getIdx()
                        , list.get(startIdx).getDuration()));

                startIdx++;
            }

            if (!pq.isEmpty()) {
                Work work = pq.poll();
                answer[answerIdx++] = work.getIdx();
                t += work.getDuration();
            } else {
                t = list.get(startIdx).getStart();
            }
        }
        return answer;
    }
}
package CodingTest8;
/**
 * 코딩 테스트 당시 20점
 *
 * 1. 주어진 start, end, price 배열을 Counsel class에 담아 한번에 비교값을 바로 확인할 수 있게 한다.
 * 2. 먼저 Counsel 클래스 타입 ArrayList에  { 시작 시간, 종료 시간, 비용 }을 담고 시작 시간 기준으로 오름차순 정렬.
 * 3. findNextMeeting 메서드는 이분탐색을 통해 idx 의 종료시간 이후 바로 이어서 상담할 수 있는 제일 빠른 상담을 찾는다.
 * 4. 역순으로 상담 시작 시간이 제일 늦은 상담부터 cache를 업데이트
 *      -> cache[idx]는 idx 번째 상담 기준 이후 가능한 최대의 상담 비용을 의미
 *      -> 따라서, cache[idx]를 { idx번째 상담 비용 + cache[findNextMeeting을 통해 찾은 상담], cache[idx + 1] } 중 최댓값으로 업데이트
 * 5. cache배열의 0번 인덱스 값은 주어진 강의 안에 가장 높게 누적된 price값이 저장되어,
 *      해당 값이 가능한 최대의 상담 비용이 된다.
 *
 */

import java.util.*;

public class CodingTest1_김우진 {
    public static class Counsel {

        private int start;

        private int end;

        private int price;

        public Counsel(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getPrice() {
            return price;
        }
    }

    public static int solution(int[] start, int[] end, int[] price) {
        int N = start.length;
        List<Counsel> counsels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            counsels.add(new Counsel(start[i], end[i], price[i]));
        }

        counsels.sort(Comparator.comparingInt(Counsel::getStart));

        int[] cache = new int[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            int nextMeetingIdx = findNextMeeting(i + 1, counsels.get(i).getEnd(), counsels);
            System.out.format("%d번 째 상담의 종료 시간을 기준으로 다음에 시작하는 상담은 %d번째 상담이다", i, nextMeetingIdx);
            System.out.println();

            cache[i] = Math.max(cache[nextMeetingIdx] + counsels.get(i).getPrice(), cache[i + 1]);
        }

        return cache[0];
    }

    public static int findNextMeeting(int idx, int getEnd, List<Counsel> counsels) {
        int left = idx;
        int right = counsels.size();
        int nextMeetingIdx = counsels.size();

        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid == counsels.size()) {
                return mid;
            }
            if (counsels.get(mid).getStart() >= getEnd) {
                nextMeetingIdx = Math.min(nextMeetingIdx, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nextMeetingIdx;
    }

    public static void main(String[] args) {
        int[] start = {1, 5, 10, 6, 5};
        int[] end = {5, 6, 12, 9, 12};
        int[] price = {10, 40, 30, 20, 50};

        System.out.println(solution(start, end, price));
    }
}
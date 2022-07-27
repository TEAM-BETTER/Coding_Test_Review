package CodingTest9;

import java.util.PriorityQueue;

/**
 * 크루스칼 알고리즘
 * 1. x배열과 y배열을 하나의 좌표로 보고, 각각의 index를 담고,
 *      두 점의 거리 dist를 Coordinate class에 한번에 담음
 *      크루스칼알고리즘은 간선 중 최소값을 가진 간선부터 연결함
 * 2. findParent 메서드를 통해 좌표 간 연결됨 유무를 판단
 * 3. parents 인덱스 각 배열 안에 자신의 index값으로 셋팅해줌
 *      -> parents[1] == 1; parents[2] == 2;...
 * 4. 주어진 모든 좌표의 조합을 PriorityQueue에 넣어줌
 * 5. 이후는 다익스트라처럼 pq에 값이 남은 데이터가 없을 때 까지 반복
 *      pq에서 poll된 데이터를 기준으로 각 idx 마다 findParent 메서드로
 *      서로 연결 되어 있는지 체크, dist값은 이동하는 가중치만큼 배열에 더해줌
 * 6. 최소값 기준으로 answer에 dist값을 더해줌
 * 7. 마지막까지 탐색 후, answer값 리턴.
 *
 */

public class CodingTest4_김우진 {

    public static int[] parents = new int[1001];

    public static class Coordinate implements Comparable<Coordinate> {

        int idx;

        int idx2;

        int dist;

        public Coordinate(int idx, int idx2) {
            this.idx = idx;
            this.idx2 = idx2;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        @Override
        public int compareTo(Coordinate o) {
            return this.dist - o.dist;
        }
    }

    public static int findParent(int idx) {
        if (parents[idx] == idx) {
            return idx;
        }

        return parents[idx] = findParent(parents[idx]);
    }

    public static int solution(int[] x, int[] y) {
        for (int i = 0; i < 1001; i++) {
            parents[i] = i;
        }

        PriorityQueue<Coordinate> pq = new PriorityQueue<>();

        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                coordinate.setDist(Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]));

                pq.add(coordinate);
            }
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            Coordinate cur = pq.poll();
            int groupIdx = findParent(cur.idx);
            int groupIdx2 = findParent(cur.idx2);
            int dist = cur.dist;

            if (groupIdx == groupIdx2) {
                continue;
            }

            parents[groupIdx] = groupIdx2;
            answer += dist;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] x = { 0, 0, 3, 3, 6 };
        int[] y = { 0, 3, 1, 4, 3 };

        System.out.println(solution(x, y));
    }
}

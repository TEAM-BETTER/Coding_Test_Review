package ch04.codingTest9.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 다익스트라로 풀었습니다.
// 다만 k 번 이하로 비행하여아 하는 알고리즘을 추가하였습니다.
public class Solution {
    public static int solution(int N, int[][] flight, int a, int b, int k) {
        int INF = Integer.MAX_VALUE;                    // cost 배열 초기화를 위한 변수
        int[] cost = new int[N];                        // 각 국가별로 도달하기 위한 최소 비용을 업데이트 하기 위한 배열
        Arrays.fill(cost, INF);                          // cost 배열 초기화
        cost[a] = 0;
        List<List<Flight>> graph = new ArrayList<>();   // 각 비행기 경로를 기록할 배열
        for (int i = 0; i < N; i++) {                   // graph 배열 초기화
            graph.add(new ArrayList<>());
        }

        for (int[] ints : flight) {                      // 모든 비행기 경로 입력
            graph.get(ints[0]).add(new Flight(
                    ints[0], ints[1], ints[2], 0));
        }

        PriorityQueue<Flight> queue = new PriorityQueue<>((x, y) -> x.cost - y.cost);  // 다익스트라 시작
        queue.add(new Flight(a, 0, 0, 0));                             // 초기 출발 노선 a 지정

        while (!queue.isEmpty()) {                  // 다익스트라
            Flight cur = queue.poll();

            if (cur.count == k) {                   // k 번 초과된 항목을 거르기위해 추가한 알고리즘
                continue;
            }

            List<Flight> ways = graph.get(cur.from);
            for (Flight way : ways) {
                if (cost[way.to] > cost[way.from] + way.cost) {
                    cost[way.to] = cost[way.from] + way.cost;
                    queue.add(new Flight(way.to, 0, cost[way.to], cur.count + 1));
                }
            }

        }

        if (cost[b] == INF) {       // b 에 도달 할 수 없으면 -1 리턴
            return -1;
        } else {                    // 도달 한다면 그 값을 리턴
            return cost[b];
        }
    }

    public static class Flight {    // 비행기 출발위치, 도착위치, 비용, 비행기 탄 횟수를 기록하기 위한 객체
        int from;
        int to;
        int cost;
        int count;

        public Flight(int from, int to, int cost, int count) {
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Flight{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 2, 1}, {1, 3, 20}, {1, 0, 8}, {2, 3, 1}, {0, 3, 3}};
        System.out.println(solution(4, a, 1, 3, 2));


    }
}

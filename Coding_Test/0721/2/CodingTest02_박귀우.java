import java.util.*;
// 릿코드에서 풀어봤던 문제였습니다. 
// https://leetcode.com/problems/cheapest-flights-within-k-stops/
// 최단경로 문제 라고 생각했습니다.
// 추가적인 조건으로 최소 경유가 정해져 있기 때문에 그 경유에 따른 로직을 구현하고자 생각했습니다.
// 각 국가별 이동경로를 추가해주기 위해 map 이용해서 구현해 보았습니다.

class Solution {
    void init(int[][] flights, Map<Integer, List<int[]>> graph) {
        for (int[] flight : flights) { // 비행 에 따른 그래프 이니셜라이징
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
    }

    public int solution(int n, int[][] flights, int a, int b, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>(); // 비행기 항로를 담을
        init(flights, graph); // init() 시작

        PriorityQueue<int[]> q = new PriorityQueue<>((c1, c2) -> Integer.compare(c1[1], c2[1]));
        // 가격에 따른 우선순위 큐 생성
        q.add(new int[] { a, 0, 0 });

        HashMap<Integer, Integer> seen = new HashMap<>();
        // 방문 처리 위해 map 으로 구현
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int city = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (!seen.containsKey(city) || stops < seen.get(city)) // 방문여부 체크 , 경유여부 가 작은지 확인
                seen.put(city, stops);
            else
                continue;

            if (city == b)
                return cost;

            if (stops > k || !graph.containsKey(city))
                continue;

            for (int[] adjCity : graph.get(city)) { // 위케이스 모두 통과시 가능한 지역들을 큐에 넣어줌
                q.add(new int[] { adjCity[0], cost + adjCity[1], stops + 1 });
            }
        }
        return -1;
    }
}
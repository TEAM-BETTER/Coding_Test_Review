package codiingTest.codingTest13.p4;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 최단거리 문제
// 다익스트라로 풀었습니다.
// 윳놀이는 뭐가 나오는지 상관하지 않고 최소값으로 가야 하므로 한번에 가장 멀리 갈수 있는 모 가 두번 나오는 상황만 고려하여
// 목표지점까지 최소거리를 구하고 그 (최소거리 + 10) 값을 10으로 나눈 값이 정답
// 최소거리 + 10 을 하는 이유는 나머지 값이 있을 때 한번 더 던져야 하므로 그 값을 계산해주기 위함
public class Solution {
    public int solution(int N, int[][] edges) {
        int distance = 0;                               // 최소 거리 구해서 저장할 변수
        List<List<Integer>> graph = new ArrayList<>();  // 노드간의 연결을 구현할 배열
        for (int i = 0; i < N + 1; i++) {               // 배열 초기화
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {                      // 배열 저장
            graph.get(edge[0]).add(edge[1]);
        }

        // 다익스트라 시작
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
                                                        // pq를 이용해 다익스트라 구현
        queue.add(new int[]{1, 0});                     // 초기값 출발지를 저장 // int[]{위치, 거리}
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int position = cur[0];
            int count = cur[1];
            if (position == N) {
                distance = count;
                break;
            }

            for (int next : graph.get(position)) {
                queue.add(new int[]{next, count + 1});
            }
        }

        return (distance + 10) / 10;                    // (최소거리 + 10) / 10 한 값을 리턴
    }
}


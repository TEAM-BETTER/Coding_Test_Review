package CodingTest10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1. 2중 ArrayList를 사용해서 edge[0] 출발지 기준으로 목적지 edge[1]과 거리 edge[2]를 입력
 * 2. PriorityQueue는 출발지를 기준 정렬
 * 3. PriorityQueue 배열을 다 확인할 때 까지 반복
 *      -> pq에서 꺼낸 값을 기준으로 목적지까지 거리를 distance배열에 기록
 *      -> 최단거리를 기록 할 수 있게 함
 * 4. 0번 장소를 기준으로 도달할 수 있는 장소 중 가장 높게 기록 된 index값을 리턴
 */
public class CodingTest5_김우진 {

    public static int solution(int N, int[][] edge) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0});

        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0];
            int node = cur[1];

            if (distance[node] < dist) {
                continue;
            }

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextDist = dist + next[1];

                if (distance[nextNode] > nextDist) {
                    distance[nextNode] = nextDist;

                    pq.add(new int[]{nextDist, nextNode});
                }
            }
        }

        int answer = 1;
        int curDist = distance[1];

        for (int i = 2; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                continue;
            }

            if (distance[i] <= curDist) {
                continue;
            }

            curDist = distance[i];
            answer = i;
        }

        return answer;
    }
}

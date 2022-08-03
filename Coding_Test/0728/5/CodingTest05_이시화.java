package codiingTest.codingTest10.p5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 이전 코테의 1 번 문제와 유사함
// 출발지에서 갈 수 있는 모든 위치의 최단거리를 구한 후
// 가장 큰 값을 반환 하는 문제
// 마찬가지로 벨만포드 알고리즘 수행
// 출발 노드에서 모든 노드까지 다익스트라 수행해도 됨
// 둘의 시간 복잡도 차이
// E = 간선 개수, V = 정점 개수
// 밸만포드 = O(V * E)
// 다익스트라 = O(E * logV) * (V - 1) (모든 노드 돌아 봐야해서 (V - 1) 곱해줌)
// V * E < V * E * logV
// 밸만 포드가 더 빠를 것으로 예상
public class Solution {
    public static int solution(int N, int[][] edge) {
        int answer = 0;
        List<List<int[]>> graph = new ArrayList<>();    // 갈 수 있는 위치 기록할 List

        for (int i = 0; i < N; i++) {                   // graph 초기화
            graph.add(new ArrayList<>());
        }

        for (int[] ints : edge) {                       // 갈 수 있는 모든 간선 graph dp 추가
            graph.get(ints[0]).add(ints);
        }

        int[] DP = new int[N];                          // 거리를 기록할 DP 배열
        int INF = Integer.MAX_VALUE;                    // DP 초기화를 위한 변수
        Arrays.fill(DP, INF);                            // 모든 DP 노드 초기화
        DP[0] = 0;                                      // 출발 노드 초기화

        for (int i = 0; i < N; i++) {                   // 밸만포드 시작
            for (int j = 0; j < graph.size(); j++) {
                List<int[]> Node = graph.get(j);
                for (int[] next : Node) {
                    if (DP[j] != INF && DP[next[1]] > DP[j] + next[2]) {
                        DP[next[1]] = DP[j] + next[2];
                    }
                }
            }
        }

        int max = 0;                            // 가장 큰 값을 찾기 위한 변수
        for (int i = 0; i < DP.length; i++) {   // DP 에 기록된 모든 값 중 가장 큰 값을 찾음
            if (DP[i] > max) {
                max = DP[i];
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 1, 5}, {0, 2, 7}, {1, 3, 10}, {3, 4, 8}, {2, 4, 9}, {4, 2, 1}};
        System.out.println(solution(5,a));
    }
}

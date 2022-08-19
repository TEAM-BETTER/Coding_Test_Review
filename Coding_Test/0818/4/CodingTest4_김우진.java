package CodingTest13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 정확성 : 4 / 시간초과 및 런타임 에러
 *
 * 1. Map 에 edges 배열을 기준으로 key : 이전노드 / value : list 형태로 다음노드를 담아줌
 *
 * 2. func 재귀 -> 도, 개, 걸 나왔을 경우로 재귀
 *             -> 윷, 모 나왔을 경우로 재귀
 *             -> idx 값이 N이 되면 도착지에 도달
 *
 */

public class CodingTest4_김우진 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();

    static int answer = Integer.MAX_VALUE;

    static void func(int idx, int cnt, int total, boolean repeat, int N) {
        // 도착점 도착하면 몇 번 굴렸나 업데이트
        if (idx == N) {
            answer = Math.min(answer, total);

            return;
        }

        for (Integer next : graph.get(idx)) {
            // 윷을 다시 돌려야하면
            if (cnt == 0) {

                // 도 개 걸
                // next로 한번 움직였으므로 0 1 2
                // 그 전에 윷, 모였으면 total 1 증가 시키지 않고
                // 도 개 걸이므로 반복 false
                for (int i = 0; i <= 2; i++) {
                    func(next, i, repeat ? total : total + 1, false, N);
                }

                // 윷 모
                // 그 전에도 윷 모였으면 repeat false 그 외 true
                for (int i = 3; i <= 4; i++) {
                    func(next, i, repeat ? total : total + 1, !repeat, N);
                }

            } else {

                // 이전에 던진 윷에 의해 움직이므로 total 증가 안하고 cnt만 1 감소
                func(next, cnt - 1, total, repeat, N);
            }
        }
    }

    public static int solution(int N, int[][] edges) {
        for (int i = 0; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 단방향 그래프 그리고
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // 1번부터 출발
        func(1, 0, 0, false, N);

        return answer;
    }

    public static void main(String[] args) {
        int N = 13;
        int[][] edges = {
                {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {4, 7}, {5, 7}, {6, 5}
                , {6, 8}, {7, 9}, {8, 10}, {9, 10}, {10, 11}, {11, 12}, {12, 13}};

        System.out.println(solution(N, edges));
    }
}
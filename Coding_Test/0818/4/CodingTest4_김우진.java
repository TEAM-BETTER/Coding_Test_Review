package CodingTest13;

import java.util.*;

/**
 *  1. Map 에 edges 배열을 기준으로 key : 이전노드 / value : list 형태로 다음노드를 담아줌
 *      State : idx, cnt를 담고 cnt가 적은 순으로 오름차순 정렬
 *  2. 항상 출발점인 1번 노드를 초기값으로 pq에 넣고 노드 탐색
 *      -> 한 번 이동 할 때마다 cnt++,
 *      -> 도착점에 도착했을 때 cnt는 시작점에서 도착점까지의 최소 길이
 *      -> 윷놀이에서 모 + 모가 베스트 케이스 (한 턴에 10칸을 이동)
 *      -> 따라서 시작점 ~ 도착점까지의 최소 길이가 몇 턴만에 이루어졌나를 확인해야함
 *      -> (시작점에서 도착점까지의 최소 길이 + 10) / 10이 최소 턴수 (시화님 코드 참고 감사합니다 )
 *
 */
public class CodingTest4 {

    static final int MAX_DISTANCE_PER_TURN = 10;

    static Map<Integer, List<Integer>> graph = new HashMap<>();

    static class State implements Comparable<State> {
        int idx;

        int cnt;

        public State(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(State o) {
            return cnt - o.cnt;
        }
    }

    public static int solution(int N, int[][] edges) {
        for (int i = 0; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.idx == N) {
                return (cur.cnt + MAX_DISTANCE_PER_TURN) / MAX_DISTANCE_PER_TURN;
            }

            for (int next : graph.get(cur.idx)) {
                pq.add(new State(next, cur.cnt + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 79;
        int[][] edges = {
                {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15}, {15, 16}, {16, 17}, {17, 18}, {18, 19}, {19, 20}, {20, 21}, {21, 22}, {22, 23}, {23, 24}, {24, 25}, {25, 26}, {26, 27}, {27, 28}, {28, 29}, {29, 30}, {30, 31}, {31, 32}, {32, 33}, {33, 34}, {34, 35}, {35, 36}, {36, 37}, {37, 38}, {38, 39}, {39, 40}, {40, 41}, {41, 42}, {42, 43}, {43, 44}, {44, 45}, {45, 46}, {46, 47}, {47, 48}, {48, 49}, {49, 50}, {50, 51}, {51, 52}, {52, 53}, {53, 54}, {54, 55}, {55, 56}, {56, 57}, {57, 58}, {58, 59}, {59, 60}, {60, 61}, {61, 62}, {62, 63}, {63, 64}, {64, 65}, {65, 66}, {66, 67}, {67, 68}, {68, 69}, {69, 70}, {70, 71}, {71, 72}, {72, 73}, {73, 74}, {74, 75}, {75, 76}, {76, 77}, {77, 78}, {78, 79}, {79, 80}
        };

        System.out.println(solution(N, edges));
    }
}

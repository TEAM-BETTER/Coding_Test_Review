/*
N개 국가 : 0 ~ N-1
비행기편 flight[i] = 출발지, 도착지, 비용
k번 이하로 탑승하면서 a -> b의 최소비용
불가능하면 -1

1. 아이디어
다익스트라로 최단거리
경유지 개수 체크를 위해 변수 하나 더 두기

2. 시간복잡도
가능

3. 변수
int 가능
 */

// 20점 통과

import java.util.ArrayList;
import java.util.PriorityQueue;

public class test002 {
    static class AirPlane {
        int to;
        int weight;
        int cnt; // 경유 횟수를 노드 안에 넣음

        public AirPlane(int to, int weight, int cnt) {
            this.to = to;
            this.weight = weight;
            this.cnt = cnt;
        }
    }
    static ArrayList<ArrayList<AirPlane>> graph;

    public static int solution(int N, int[][] flight, int a, int b, int k) {
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int answer = 0;

        for (int i = 0; i < flight.length; i++) {
            graph.get(flight[i][0]).add(new AirPlane(flight[i][1], flight[i][2], 0));
        }
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<AirPlane> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new AirPlane(a, 0, 0));

        while(!pq.isEmpty()) {
            AirPlane cur = pq.poll();
            if(dp[cur.to] < cur.weight) {
                continue;
            }
            // 현재 경유 횟수가 k - 1번보다 크면 다음 연결 때 k번이 되기 때문에 제외
            if(cur.cnt > k - 1) {
                continue;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                AirPlane adj = graph.get(cur.to).get(i);
                if(dp[adj.to] > cur.weight + adj.weight) {
                    dp[adj.to] = cur.weight + adj.weight;
                    pq.offer(new AirPlane(adj.to, dp[adj.to], cur.cnt + 1));
                }
            }
        }

        if(dp[b] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[b];
    }

    public static void main(String[] args) {
        int N = 4;
        int a = 1;
        int b = 3;
        int k = 2;
        int[][] flight = {{0,2,1}, {1,3,20}, {1,0,8}, {2,3,1}, {0,3,3}};
        System.out.println(solution(N, flight, a, b, k));
    }
}

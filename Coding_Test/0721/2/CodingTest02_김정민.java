import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
*  a -> b 까지 가는 최단거리중 거치는 정점이 k개 이하인 경로를 찾는 문제
*  a -> b 까지 다익스트라 구함.
*  다익스트라를 구하는 중 현재 거쳐진 경로가 k번째 이상이라면 패스
* */
class Solution {
    public int solution(int N, int[][] flight, int a, int b, int k) {
        int INF = 999999999;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        // 다익스트라의 값을 나타내는 변수 거쳐간 경로까지 새기 위해 Node 생성
        // d[i].cnt는 a에서 부터 i까지 가는 경로중 거쳐간 정점의 개수
        Node[] d = new Node[N];

        for (int i = 0; i < N; i++) {
            d[i] = new Node(INF, 0);
        }
        d[a] = new Node(0, 0);

        for (int i = 0; i < flight.length; i++) {
            int st = flight[i][0];
            int end = flight[i][1];
            int cost = flight[i][2];

            adj.get(st).add(new Edge(end, cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(a, d[a].cost));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (d[cur.v].cost != cur.cost) continue;
            for (Edge edge: adj.get(cur.v)) {
                if (d[edge.v].cost <= d[cur.v].cost + edge.cost) continue;
                if (d[edge.v].cnt >= k) continue; // edge가 k번이상이면 패스

                d[edge.v].cost = d[cur.v].cost + edge.cost;
                d[edge.v].cnt = d[cur.v].cnt + 1; // 현재 정점의 cnt + 1
                pq.add(new Edge(edge.v, d[edge.v].cost));
            }
        }

        return d[b].cost == INF ? -1 : d[b].cost;
    }

    static class Node {
        int cost;
        int cnt;

        public Node(int cost, int cnt) {
            this.cost = cost;
            this.cnt = cnt; // 몇 번째인가
        }

    }
    static class Edge {
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
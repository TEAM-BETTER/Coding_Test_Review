import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
*  한 정점으로부터 모든 정점까지 거리가 필요하다고 생각해서 다익스트라 알고리즘을 이용 했습니다.
* */
class Solution {
    public int solution(int N, int[][] edge) {
        int answer = 0;
        int INF = 999999999; // 다익스트라에 미 방문용 최대 값 Integer.MAX_VALUE는 불안해서 사용을 못하겠네요 ㅠㅠ
        // 다익스트라에서 사용할 인접리스트 세팅
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        // 정점 0으로부터의 거리 세팅
        int[] d = new int[N];
        Arrays.fill(d, INF);
        d[0] = 0;
        // edge를 읽어서 adj 초기화
        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            int cost = edge[i][2];
            adj.get(start).add(new Edge(end, cost));
        }

        // 다익스트라 시작
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(0, d[0]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (d[cur.v] != cur.cost) continue;
            for (Edge edgeNode: adj.get(cur.v)) {
                if (d[edgeNode.v] <= d[cur.v] + edgeNode.cost) continue;
                d[edgeNode.v] = d[cur.v] + edgeNode.cost;
                pq.add(new Edge(edgeNode.v, d[edgeNode.v]));
            }
        }

        // INF가 아닌 값중 최대값을 찾아서 인덱스 반환!
        int index = 0;
        int temp = 0;

        for (int i = 1; i < N; i++) {
            if (d[i] == INF) continue;
            if (temp < d[i]) {
                temp = d[i];
                index = i;
            }
        }
        return index;
    }

    static class Edge {
        int v; // 도착점
        int cost; // 비용

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
   문제가 기억이 안나네요 ㅠ
*  0번 친구 기준으로 다익스트라
* */
class Solution {
    public int solution(int N, int[][] friend, int[][] time) {
        int INF = 999999999;

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        int[] d = new int[N];

        Arrays.fill(d, INF);
        d[0] = 0;
        for (int i = 0; i < friend.length; i++) {
            for (int j = 0; j < friend[i].length; j++) {
                int v = friend[i][j]; // i번째 친구와 친한 친구들
                int t = time[i][j];
                adj.get(i).add(new Edge(v, t));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(0, d[0]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (d[cur.v] != cur.cost) continue; // 다른경우에는 최단 거리가 아니므로 아무 것도 하지 않는다.
            for (Edge edge: adj.get(cur.v)) {
                if (d[edge.v] <= d[cur.v] + edge.cost) continue;
                d[edge.v] = d[cur.v] + edge.cost;
                pq.add(new Edge(edge.v, d[edge.v]));
            }
        }

        int ans = 0;

        for (int i = 0; i < d.length; i++) {
            ans = Math.max(ans, d[i]);
        }

        return ans == INF ? -1 : ans;
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
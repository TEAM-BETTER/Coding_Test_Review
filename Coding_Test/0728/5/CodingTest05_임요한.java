// 전형적인 최단거리 문제와 똑같이 풀었습니다.
// 기본 풀이법을 외우다싶이 반복해서 이제는 다익스트라가 편하네요

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CodingTest05_임요한 {

    static int INF = 1000000000;

    static class Edge {
        int to;
        int time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    public int solution(int N, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < edge.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(new Edge(edge[i][1], edge[i][2]));
        }

        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.time - y.time);
        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            if (dist[curEdge.to] < curEdge.time) {
                continue;
            }

            for (int i = 0; i < list.get(curEdge.to).size(); i++) {
                Edge adjEdge = list.get(curEdge.to).get(i);
                if (dist[adjEdge.to] > curEdge.time + adjEdge.time) {
                    dist[adjEdge.to] = curEdge.time + adjEdge.time;
                    pq.offer(new Edge(adjEdge.to, dist[adjEdge.to]));
                }
            }
        }

        int max = -1;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] > max) {
                max = dist[i];
                answer = i;
            }
        }
        return answer;
    }
}
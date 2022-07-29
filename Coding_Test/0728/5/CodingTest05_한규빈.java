package CodingTest5;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 최장 거리를 구하는데 같은 거리가 여러개면 작은 인덱스를 반환해야해서
 * 기존 int[] dist를 int[][] dist 2차원 배열로 바꿔 0번은 idx 1번은 거리를 저장하였습니다.
 * 위의 설명한 저 부분만 다르고 나머지 코드는 강사님께서 알려주신 방법과 완전 똑같습니다.
 */
public class CodingTest05_한규빈 {

    static class Node {
        int idx;
        int to;
        int weight;

        public Node(int idx, int to, int weight) {
            this.idx = idx;
            this.to = to;
            this.weight = weight;
        }
    }

    static int M;
    static int INF = 1000000001;
    static ArrayList<ArrayList<Node>> graph;
    public static int solution(int N, int[][] edge) {

        M = N;
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(new Node(i, edge[i][1], edge[i][2]));
        }

        int[][] dist = dijkstra(graph);

        int max = Integer.MIN_VALUE;
        int minIdx = 1;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i][1] > max) {
                max = dist[i][1];
                minIdx = dist[i][0];
            } else if (dist[i][1] == max) {
                continue;
            }
        }

        return minIdx;
    }

    public static int[][] dijkstra(ArrayList<ArrayList<Node>> graph) {
        int[][] dist = new int[M][2];
        for (int i = 0; i < dist.length; i++) {
            dist[i][0] = i;
            dist[i][1] = INF;
        }

        dist[0][0] = 0;

        boolean[] visited = new boolean[M];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(0,0, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (visited[curNode.to]) {
                continue;
            }

            visited[curNode.to] = true;

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (!visited[adjNode.to]
                        && dist[adjNode.to][1] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to][1] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.idx, adjNode.to, dist[adjNode.to][1]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] edge = {{0, 1, 5}, {0, 2, 7}, {1, 3, 10}, {3, 4, 8}, {2, 4, 9}, {4, 2, 1}};
        System.out.println(solution(N, edge));
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CodingTest04 {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int solution(int N, int[][] edges) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Node(edges[i][1], 1));
        }

        int[] distanceDP = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distanceDP[i] = Integer.MAX_VALUE;
        }
        distanceDP[1] = 0;

        Queue<Node> pq = new LinkedList<>();
        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            if(distanceDP[curNode.to] < curNode.weight) {
                continue;
            }
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);
                if(distanceDP[adjNode.to] > curNode.weight + adjNode.weight) {
                    distanceDP[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, distanceDP[adjNode.to]));
                }
            }
        }
        return (distanceDP[N] / 11) + 1;
    }

    public static void main(String[] args) {
        int [][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {4, 7}, {5, 7}, {6, 5}, {6, 8}, {7, 9}, {8, 10}, {9, 10}, {10, 11}, {11, 12}, {12, 13}};
        int N = 13;
        System.out.println(solution(N, edges));
    }
}

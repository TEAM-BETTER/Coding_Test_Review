/*
전형적인 최단경로 문제풀이라
굳이 주석은 달지 않았습니다.
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

public class CodingTest05_윤지용 {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int solution(int N, int[][] edge) {
        int answer = 0;

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(new Node(edge[i][1], edge[i][2]));
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(0, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dp[cur.to] < cur.weight) {
                continue;
            }
            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(dp[adj.to] > cur.weight + adj.weight) {
                    dp[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to, dp[adj.to]));
                }
            }
        }
        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            if(dp[i] > maxWeight) {
                maxWeight = dp[i];
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] edge = {{0,1,5},{0,2,7},{1,3,10},{3,4,8},{2,4,9},{4,2,1}};
        System.out.println(solution(N, edge));
    }
}
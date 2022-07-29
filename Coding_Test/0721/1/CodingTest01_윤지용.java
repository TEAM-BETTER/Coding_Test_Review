/*
다익스트라.
목표지점이 있는게 아니라 다 돈다음에 Max값을 구해주면 됨
단, DP배열에 초기값이 있는 노드가 있으면 -1 출력
 */

// 20점 통과

import java.util.ArrayList;
import java.util.PriorityQueue;

public class test001 {
    static ArrayList<ArrayList<Node>> graph;
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static int solution(int N, int[][] friend, int[][] time) {
        int maxTime = 0;

        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < friend[i].length; j++) {
                graph.get(i).add(new Node(friend[i][j], time[i][j]));
            }
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dp[cur.to] < cur.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if (dp[adj.to] > cur.weight + adj.weight) {
                    dp[adj.to] = cur.weight + adj.weight;
                    // maxTime = Math.max(maxTime, dp[adj.to]); <- 처음에는 연결하는 부분에서 최대값을 구했더니 3개 틀려서 dp배열 돌릴때 구하도록 옮겨서 통과했습니다.
                    pq.offer(new Node(adj.to, dp[adj.to]));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            // 연결 안된 부분이 있으면
            if (dp[i] == Integer.MAX_VALUE) {
                return -1;
            }
            // dp 최대값 찾기
            maxTime = Math.max(maxTime, dp[i]);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] friend = {{1,4}, {2,3}, {4}, {1,3}, {0,2}};
        int[][] time = {{5,2}, {6,4}, {9}, {1,5}, {2,6}};
        System.out.println(solution(N, friend, time));
    }
}

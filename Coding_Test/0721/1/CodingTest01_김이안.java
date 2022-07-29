import java.util.*;
/*
다익스트라 알고리즘으로 푼 문제입니다!
문제에서 제공하는 데이터가 다른 다익스트라 문제와 다르게 제공되기 때문에
기존에 쓰던 { from, to, weight } 형태로 정렬해서 진행했습니다.
*/
class Solution {
    static class Node implements Comparable<Node> {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {      //weight 오름차순으로 정렬하는 compareTo입니다. 우선순위 큐에 쓰입니다.
            return this.weight - o.weight;
        }
    }
    private static void dijkstra(ArrayList<ArrayList<Node>> graph, int V, int E, int[] distance) {
        /*
            graph = { from, ( to , weight) }
            V = 정점 개수
            E = 간선 개수
            distance = 거리 배열 (초기값 0)

            distance 배열의 값을 채워주는 메소드입니다.
        */
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) distance[i] = Integer.MAX_VALUE;    // distance 값이 메소드가 끝날때까지 Integer.MAX_VALUE 라면 도달하지 못한 정점입니다.
        distance[0] = 0;        // 무조건 0번 친구에게 처음 거짓말을 해서 0번 친구의 distance를 0으로 초기화 해줍니다.

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            int current = pq.poll().to;

            if (visited[current]) continue;     // 이미 방문한 정점은 다시 방문하지 않습니다.
            visited[current] = true;

            ArrayList<Node> currentNode = graph.get(current);   //현재 정점 to 값의 노드
            int size = currentNode.size();

            for (int i = 0; i < size; i++) {

                int t = currentNode.get(i).to;  //현재 노드 to 값
                int w = currentNode.get(i).weight;  //현재 노드 weight 값

                if (distance[t] > distance[current] + w) {
                    distance[t] = distance[current] + w;
                    pq.offer(new Node(t, distance[t]));
                }
            }
        }
    }
    public int solution(int N, int[][] friend, int[][] time) {
        int E = 0;  // 간선 개수
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();   // { from (to, weight)} 값으로 데이터를 정리합니다.
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < friend.length; i++) {
            for (int j = 0; j < friend[i].length; j++) {
                graph.get(i).add(new Node(friend[i][j], time[i][j]));
                E++;
            }
        }

        int[] distance = new int[N];
        dijkstra(graph, N, E, distance);

        int answer = 0;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;    // 도달하지 못한 경우 -1을 리턴
            answer = Math.max(answer, distance[i]);     // 모든 노드에 distance값이 있는 경우 최대 간선 길이를 리턴
        }
        return answer;
    }
}
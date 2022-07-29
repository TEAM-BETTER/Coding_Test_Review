import java.util.*;
/*
    기본적인 다익스트라 문제였습니다.
    모든 노드까지의 최단거리를 구하고 그 중 최단거리가 제일 큰 노드를 리턴합니다.
*/
class Solution {
    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] edge) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();    // 다익스트라를 위한 2차원 배열
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(new Node(edge[i][1], edge[i][2]));
        }

        boolean[] visited = new boolean[N];
        int[] dist = new int[N];        // 각 노드의 거리

        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        for (int i = 0; i < N; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;
            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                if( dist[i] > max){
                    max = dist[i];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }
}
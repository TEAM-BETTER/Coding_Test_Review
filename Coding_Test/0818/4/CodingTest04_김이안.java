/*
* 16점 코드입니다
* minDistance 메소드로 시작점~도착점의 최단 거리를 찾습니다
* 최단거리/10을 리턴합니다
* */import java.util.*;
class Solution {
    public static class Node{
        int num;    // 노드 숫자
        int step;   // 거리

        public Node(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }
    public int solution(int N, int[][] edges) {
        int distance = minDistance(N, edges);
        distance = distance == Integer.MAX_VALUE ? 0 : distance;    // 거리가 Integer.Max일 경우 도착점에 도착하지 못하는 경우 입니다.
        return (int) Math.ceil((double)distance / 10);
    }
    public static int minDistance(int N, int[][] edges) {
        Arrays.sort(edges, (x, y) -> x[0] - y[0]);
        Node node = new Node(1, 0);
        ArrayDeque<Node> queue = new ArrayDeque<Node>();        // 큐보다 덱이 빠르다고 해서..
        boolean[] visited = new boolean[N];
        int minStep = Integer.MAX_VALUE;
        queue.add(node);
        while (!queue.isEmpty()) {                              // bfs 방식으로 최단거리를 구합니다
            Node curNode = queue.poll();
            if (curNode.num == N) {
                minStep = Math.min(minStep, curNode.step);
                continue;
            }
            visited[curNode.num - 1] = true;
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][0] == curNode.num && !visited[edges[i][1] - 1]) {
                    queue.add(new Node(edges[i][1], curNode.step + 1));
                }
            }
        }
        return minStep;
    }
}
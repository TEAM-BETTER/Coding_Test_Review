/*
최소 스패닝 트리.
주어진 배열을 어떻게 graph에 넣을지가 문제의 핵심!
이라고 생각했는데 잘 넣었는것 같은데도 16점입니다.
마지막 테스트케이스가 런타임 초과가 났어요..
 */

// 16점

import java.util.ArrayList;
import java.util.PriorityQueue;


public class test004 {
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int solution(int[] x, int[] y) {
        int weightSum = 0;

        graph = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) { // 맨하탄 거리 구하는 메서드 아래 따로
                graph.get(i).add(new Node(j, getDistance(x[i], x[j], y[i], y[j])));
                graph.get(j).add(new Node(i, getDistance(x[i], x[j], y[i], y[j])));
            }
        }

        boolean[] visited = new boolean[x.length];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Node(x[0], 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.to]) {
                continue;
            }
            cnt++;
            visited[cur.to] = true;
            weightSum += cur.weight;

            if(cnt == x.length) {
                return weightSum;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adjNode = graph.get(cur.to).get(i);
                if(visited[adjNode.to]) {
                    continue;
                }
                pq.add(adjNode);
            }
        }
        return weightSum;

    }
    // 맨하탄 거리 메서드
    static int getDistance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) {
        int[] x = {0,0,3,3,6};
        int[] y = {0,3,1,4,3};
        System.out.println(solution(x, y));
    }
}
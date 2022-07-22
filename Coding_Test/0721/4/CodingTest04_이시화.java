package ch04.codingTest9.p4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


// 최소신장트리 프림으로 풀이
// 유니온 파인드(크루스칼)보다 수가 많을 때 유리하다하여 사용
public class Solution {
    public int solution(int[] x, int[] y) {
        int answer = 0;
        int len = x.length;
        boolean[] isVisited = new boolean[len];     // 프림 알고리즘을 위한 방문 확인 배열
        List<List<Node>> graph = new ArrayList<>(); // 각 좌표 별로 이동할 수 있는 모든 경우를 저장할 배열

        for (int i = 0; i < len; i++) {             // i 번째 점 (x[i], y[i])에서 모든 점까지 manhattan 거리 계산해서 graph에 저장
            graph.add(new ArrayList<>());
            List<Node> ways = graph.get(i);
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                ways.add(new Node(j, manhattan(x[i], y[i], x[j], y[j])));
            }
        }

        // 프림 알고리즘으로 모든 점을 이을 수 있는 최소 거리를 구함
        PriorityQueue<Node> queue = new PriorityQueue<>((d, e) -> d.weight - e.weight);
        queue.add(new Node(1, 0));
        int count = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (!isVisited[cur.to]) {
                isVisited[cur.to] = true;
                count++;
                answer += cur.weight;
            }

            if (count == len) {
                return answer;
            }

            List<Node> ways = graph.get(cur.to);

            for (Node next : ways) {
                if (!isVisited[next.to]) {
                    queue.add(next);
                }
            }
        }

        return answer;
    }

    // 문제에 제시된 manhattan 거리 구하는 함수
    public static int manhattan(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }

    // 좌표를 위한 객체
    private static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}

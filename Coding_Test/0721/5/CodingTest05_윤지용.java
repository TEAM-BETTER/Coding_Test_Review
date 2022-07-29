/*
시험문제 총 N개
연관이 기깊은 문제는 relations[i]에 {문제번호1, 문제번호2, 소요시간}
문제번호는 0 ~ N-1
연관되지 않은 독립적인 문제는 30분 소요
N개를 공부하는데 최소 몇분?

1. 아이디어
모든 문제 하나의 선으로 연결 -> 최소 스패닝 트리
연결된 정점은 모두 연결하고, 연결 안된 노드는 30분씩 더해주면 됨.
 */

// 12점.
// 제 생각에는 최소 스패닝 돌리면 독립적인 문제도 있겠지만,
// 연결이 되어 있는데 처음 시작한 트리와 연결이 안된 그룹이 누락되지 않았을까? 싶은 생각입니다.
// 예를 들어
// 0 - 0 - 0 - 0        0 - 0 - 0       0    
// 이렇게 3그룹이 있고 첫번째 그룹에서 스패닝이 돌아가면,
// 3번째 그룹은 30분 추가하면 되는데 2번째 그룹은 30분씩 추가하면 안되는데,
// 그래서 통과 못한거 같은데
// 그래서 고처야 하는데
// 그런데 못했어요

import java.util.ArrayList;
import java.util.PriorityQueue;

public class test005 {
    static ArrayList<ArrayList<Node>> graph;
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int solution(int N, int[][] relations) {
        // 처음에는 relations 배열에 있는 것부터 시작을 했는데,
        // 가장 연관이 많은걸로 해야되나? 싶어 이후에 다시 업데이트 해줬습니다.
        int startNode = relations[0][0];
        // 시작 후보지를 확인할 배열
        // 그래프 그리면서 다른 문제와 얼마나 연관이 있는지 카운트해서 넣음
        int[] startCandidate = new int[N];

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        for (int i = 0; i < relations.length; i++) {
            graph.get(relations[i][0]).add(new Node(relations[i][1], relations[i][2]));
            graph.get(relations[i][1]).add(new Node(relations[i][0], relations[i][2]));
            startCandidate[relations[i][0]]++; // 문제 연관횟수 카운트
        }

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if(startCandidate[i] > tmp) {
                tmp = startCandidate[i];
                startNode = i; // 가장 연관이 많은 시작문제 픽
            }
        }

        pq.add(new Node(startNode, 0));

        int weightSum = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;
            weightSum += cur.weight;

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(visited[adj.to]) {
                    continue;
                }
                pq.offer(new Node(adj.to, adj.weight));
            }
        }

        // 연관없는 문제 시간까지 더해줘야
        int noRelation = 0;
        for (int i = 0; i < N; i++) {
            if(visited[i]==false) { // 방문 안됐으면
                noRelation += 30; // 30분씩 더해줌
            }
        }
        return weightSum + noRelation + 30; // 맨 처음에 공부하는 문제 30분 추가해서 출력
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] relations = {{2,3,15}, {1,5,10}, {3,4,25}, {1,2,27}, {1,4,29}, {2,5,5}};
        System.out.println(solution(N, relations));
    }
}


package ch04.codingTest9.p5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 4번 문제와 동일한 문제
// 하지만 한번에 모든 객체를 이을 수 없을때 한번더 알고리즘을 돌려주는 방식이 필요
// 한번 더 돌려주면 30분의 초기 시간 필요
public class Solution {
    public static boolean[] isVisited;      // 프림 알고리즘을 위한 방문 체크 배열
    public static List<List<Node>> graph;   // 각 문제별로 연관 관계 저장 배열

    public static int solution(int N, int[][] relations) {
        int answer = 30;                    // 처음 푸는 문제는 초기 30분 필요해서 30으로 지정
        isVisited = new boolean[N];         // 방문 배열 초기화
        graph = new ArrayList<>();          // graph 초기화
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {  // graph 배열에 모든 문제의 연관관계 입력 // 한쪽 방향으로만 연관관계가 아니기 때문에 양방향으로 추가
            graph.get(relation[0]).add(new Node(relation[1], relation[2]));
            graph.get(relation[1]).add(new Node(relation[0], relation[2]));
        }

        answer = cur(1, answer, N); // 프림 알고리즘 처음 돌려줌
        // 프림 알고리즘 돌리면 1 번 문제와 연결할 수 있는 모든 문제를 최소 시간으로 열결해줌

        for (int i = 0; i < isVisited.length; i++) {    // 프림 알고리즘을 한번 돌리고 난 후 1번 문제와 이어지지 않은 문제 찾기
            if (!isVisited[i]) {                        // 찾은 문제에서 다시 프림 알고리즘 실행
                answer += cur(i, 30, N);        // 방문하지 않은 i번째 문제에서 알고리즘 실행 후 그 값을 처음 계산한 프림 알고리즘 값에 더해줌
            }                                           // 이후 모든 노드를 체크하며 시간 추가
        }

        return answer;
    }

    public static int cur(int start, int answer, int N) {   // 프림 알고리즘
        PriorityQueue<Node> queue = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        queue.add(new Node(start, 0));
        int count = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (!isVisited[cur.to]) {
                isVisited[cur.to] = true;
                count++;
                answer += cur.weight;
            }

            if (count == N) {
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

    private static class Node {  // 문제를 위한 객체
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 3, 15}, {1, 5, 10}, {3, 4, 25}, {1, 2, 27}, {1, 4, 29}, {2, 5, 5}};
        System.out.println(solution(6, a));
    }
}

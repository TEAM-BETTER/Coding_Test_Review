package CodingTest10;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1. Node: leftNode, rightNode, parentNode
 *      -> dfs : 리프노드를 구하는 메서드
 *      left, right가 null이 아니면 계속 depth를 타고 내려가 리프노드값을 nodes에 입력
 *      left가 탐색의 우선이 됨
 *
 * 2. 주어진 left와 right 배열을 기반으로 이진 트리를 graph로 표현
 *     -> 이 때, 각 노드의 부모 노드도 저장
 * 3. 0번 노드가 무조건 root 노드
 *     -> answer 배열을 다 채울 때까지 while문을 돌며
 *     -> 0번 루트 기준 dfs를 수행해 leafNode들을 nodes 어레이리스트에 저장
 *     -> dfs는 왼쪽 우선으로 탐색하므로 answer에 넣어줄 때는 nodes에 들어간 역순으로 추가
 *     -> leafnode를 answer에 추가해주면 leafnode를 제거해야하므로 부모노드와 연결을 끊어줌
 *
 */
public class CodingTest3_김우진 {
    static class Node {
        Integer leftNode;

        Integer rightNode;

        Integer parentNode;
    }

    static List<Integer> nodes;

    static ArrayList<Node> graph;

    static void dfs(int idx) {
        Integer leftNode = graph.get(idx).leftNode;
        Integer rightNode = graph.get(idx).rightNode;

        if (leftNode != null) {
            dfs(leftNode);
        }

        if (rightNode != null) {
            dfs(rightNode);
        }

        if (leftNode == null && rightNode == null) {
            nodes.add(idx);
        }
    }

    public static int[] solution(int N, int[][] left, int[][] right) {
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new Node());
        }

        for (int[] pair : left) {
            graph.get(pair[0]).leftNode = pair[1];
            graph.get(pair[1]).parentNode = pair[0];
        }

        for (int[] pair : right) {
            graph.get(pair[0]).rightNode = pair[1];
            graph.get(pair[1]).parentNode = pair[0];
        }

        int root = 0;
        int[] answer = new int[N];
        int idx = 0;

        while (idx < N) {
            nodes = new ArrayList<>();

            dfs(root);

            for (int i = nodes.size() - 1; i >= 0; i--) {
                int node = nodes.get(i);
                answer[idx++] = node;

                Integer parent = graph.get(node).parentNode;

                if (parent == null) {
                    continue;
                }

                if (graph.get(parent).leftNode != null
                        && graph.get(parent).leftNode == node) {
                    graph.get(parent).leftNode = null;
                }

                if (graph.get(parent).rightNode != null
                        && graph.get(parent).rightNode == node) {
                    graph.get(parent).rightNode = null;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] left = {{0, 1}, {1, 5}, {2, 3}};
        int[][] right = {{0, 2}, {3, 4}};

        int[] answer = solution(N, left, right);

        for (int a : answer) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}

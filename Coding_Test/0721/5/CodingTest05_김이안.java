import java.util.*;
/*
    일반적인 크루스칼 알고리즘의 변형입니다.
    변형이라고 해봤자 visited2 배열 추가한게 끝입니다!
*/
class Solution {
    public int solution(int N, int[][] relations) {
        Arrays.sort(relations, (x, y) -> x[2] - y[2]);

        int[] visited = new int[N];
        boolean[] visited2 = new boolean[N];    // 첫 방문한 정점과 간선이 연결되지 않은 정점은 false입니다.
        for (int i = 0; i < N; i++) {
            visited[i] = i;
        }

        int answer = 0;
        for (int[] edge : relations) {
            int parent1 = findParent(edge[0], visited);
            int parent2 = findParent(edge[1], visited);

            if (parent1 == parent2) continue;
            answer += edge[2];
            visited[parent2] = parent1;
            visited2[parent2] = true;
        }
        for (int i = 0; i < visited2.length; i++) {
            if(!visited2[i]) answer += 30;      // 처음 방문했을시에 30분, 간선이 연경되지 않은 정점마다 +30분
        }
        return answer;
    }
    public static int findParent(int edge, int[] visited) {
        if (visited[edge] == edge) return edge;
        return findParent(visited[edge],visited);
    }
}
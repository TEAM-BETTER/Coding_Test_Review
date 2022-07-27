package CodingTest9;

import java.util.*;

/**
 * 1. 문제 간의 연관성을 체크할 findParent 메서드
 * 2. relations[2] == 소요시간별로 오름차순 정렬
 * 3. parents 배열길이는 문제의 수만큼, 초기값은 i번 문제는 i로 잡아줌
 * 4. visited 배열은 푼 문제를 체크해줌
 * 5. relations[0],relations[1] 문제는 서로 연관이 있음
 *      -> findParent 배열에 데이터를 index값으로 묶어줌
 * 6. relations[2]을 오름차순으로 정렬했기 때문에, 가장 빠르게 풀 수 있는 문제순으로 풀게됨
 *      -> answer에 문제를 푼 시간을 더해줌
        -> parents[groupA] = groupB로 풀었음을 체크
 *      -> visited[groupA] = true; 푼 문제로 바꿔줌
 * 7. 모든 문제 확인 후 visited배열에서 연관성 없이 푼 문제들은 true로 바뀌지 않았음
 *      -> 30분이 소요되는 문제 -> answer에 +30;
 * 8. 모든 문제를 푼 시간을 더한 값 리턴
 */

class CodingTest5_김우진 {
    public static int[] parents;

    public static int findParent(int idx) {
        if (parents[idx] == idx) {
            return idx;
        }

        return parents[idx] = findParent(parents[idx]);
    }

    public static int solution(int N, int[][] relations) {
        Arrays.sort(relations, Comparator.comparingInt(o -> o[2]));

        parents = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        boolean[] visited = new boolean[N];

        int answer = 0;

        for (int[] edge : relations) {
            int groupA = findParent(edge[0]);
            int groupB = findParent(edge[1]);

            if (groupA == groupB) {
                continue;
            }

            answer += edge[2];
            parents[groupA] = groupB;
            visited[groupA] = true;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == true) {
                continue;
            }

            answer += 30;
        }

        return answer;
    }
}
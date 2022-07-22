package ch04.codingTest9.p3;

// 유니온 파인드로 문제 풀이
// 감염될 확율이 있는 그룹을 유니온 파인드로 묶음
// 감염된 인원이 포함된 유니온 파인드 그룹의 수를 카운트하여 큰 값이 있는 그룹을 정답으로 리턴
public class Solution {
    public static int[] parents;    // 유니온 파인드를 위한 부모 배열

    public int solution(int N, int[][] graph, int[] infected) {
        int answer = 0;
        parents = new int[N];                           // 배열 초기화
        for (int i = 0; i < N; i++) {                   // 배열 초기화
            parents[i] = i;
        }

        for (int i = 0; i < graph.length; i++) {        // graph 배열에 감염 시킬 수 있는 인원끼리 유니온 파인드 그룹 지어줌
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int[] count = new int[N];

        for (int j : infected) {                    // j 번째 사람이 포함된 그룹의 숫자를 카운트
            int temp = 0;
            for (int parent : parents) {
                if (parent == parents[j]) {
                    temp++;
                }
            }
            count[j] = temp;
        }

        int temp = -1;                              // 가장 큰 그룹에 속하고 번호가 가장 작은 감염된 사람 추출
        for (int j : infected) {
            if (count[j] > temp) {
                temp = count[j];
                answer = j;
            }
        }

        return answer;
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) {
                parents[x] = y;
            } else {
                parents[y] = x;
            }
        }
    }
}

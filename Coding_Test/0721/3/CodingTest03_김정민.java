import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* 구성된 그래프에서 infected부터 bfs를 시작해 너비를 구한 후 최대값인 infected를 치료한다.
* 점수 16점
* */
class Solution {
    public int solution(int N, int[][] graph, int[] infected) {
        int answer = -1;
        int temp = -1; // 너비의 최대값을 저장

        // infected부터 감염시킬 수 있는 범위를 구해서 최대값인 감염자를 찾는다.
        for (int infect: infected) {
            int size = bfs(infect, N, graph);
            if (temp < size) {
                answer = infect;
                temp = size;
            }
        }

        return answer;
    }

    public int bfs(int cur, int N, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[N];
        vis[cur] = true;
        int cnt = 1;
        q.add(cur);

        while (!q.isEmpty()) {
            int next = q.poll();

            for (int i = 0; i < graph[next].length; i++) {
                if (graph[next][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {
                {1,0,1},
                {0,1,0},
                {1,0,1},
        };
        int[] infected = {0,2};

        int ans = solution.solution(3, graph, infected);
        System.out.println(ans);
    }
}
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class CodingTest03_임요한 {

    static boolean[] visited;
    public int solution(int N, int[][] graph, int[] infected) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        Arrays.sort(infected); // 작은 인덱스 값부터 출력하기 위해 정렬

        if (infected.length == 1) {
            return infected[0];
        }

        for (int i = 0; i < infected.length; i++) {
            visited = new boolean[N];
            visited[infected[i]] = true;
            int count = bfs(graph, infected[i]);
            if (count > max) { // 직/간접 연결이 가장 많이된 감염자일 수록 가장 많은 인원이 치료된다.
                max = count;
                answer = infected[i];
            }
        }
        return answer;
    }

    public int bfs(int[][] graph, int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        int count = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < graph[x].length; i++) {
                if (graph[x][i] == 1 && !visited[i] && x != i) {
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int N = 2;
        int[][] graph = {{1,1}, {1,1}};
        int[] infected = {1,0};

        System.out.println(new CodingTest03_임요한().solution(N, graph, infected));
    }
}

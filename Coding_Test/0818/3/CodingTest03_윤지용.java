public class CodingTest03 {

    static int answer;
    static boolean[] visited;

    public static int solution(int n, int m) {
        visited = new boolean[n - 1];
        if(n >= m) {
            permu(n, m, 0, 0);
        }
        return answer;
    }

    public static void permu(int n, int m, int start, int depth) {
        if(depth == m - 1) {
            answer++;
            if(answer == 100007) {
                answer = 0;
            }
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permu(n, m, i, depth + 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int n = 6;
        int m = 10;
        System.out.println(solution(n, m));
    }
}

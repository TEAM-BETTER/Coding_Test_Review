package CodingTest9;

/**
 * 시험 당시 점수 4점 : 아직 문제 자체를 이해를 못한 것 같습니다.
 * graph가 2차원 배열로 graph[0] == 1번 사람, graph[1] == 2번 사람,... 으로 생각하고
 * 만약 배열의 수가 1이면 옆에 사람이 있고 0이면 사람이 없다고 생각했습니다.
 * 그래서 2중 for문으로 vac 배열에 1의 수를 세서 가장 높은 vac[i]가
 * 주변에 가장 사람이 많다고 생각해 백신을 놔주는 것으로 생각했습니다.
 *
 */
class Solution {
    public static int solution(int N, int[][] graph, int[] infected) {
        int answer = 0;
        int [] vac = new int[N];
        int idx = 0;
        for (int i = infected[idx]; i < infected.length; i++) {
            for (int j = 0; j < infected[idx]; j++) {
                if(graph[i][j] == 1){
                    vac[infected[idx]]++;
                } else {
                    break;
                }
            }
            for (int j = infected[idx]; j < N; j++) {
                if(graph[i][j] == 1){
                    vac[infected[idx]]++;
                } else {
                    break;
                }
            }
            idx++;
        }

        int max = 0;
        for (int x :vac) {
            if (x > max) {
                max = x;
            }
        }
        for (int i = 0; i < infected.length; i++) {
            if(vac[i] == max){
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] graph = {{1,1,0},{1,1,0},{0,0,1}};
        int[] infected = {0, 2};
        System.out.println(solution(N, graph,infected));

    }
}
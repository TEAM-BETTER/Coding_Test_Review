import java.util.*;
/*
    문제 이해가 잘 안돼서 제일 마지막에 풀었던 문제입니다.
    15분 정도 남았을때 푼 문제지만 운좋게도 16점 코드입니다.

*/
class Solution {
    public int solution(int N, int[][] graph, int[] infected) {
        int answer = 0;
        int max = 0;        // 최대 감염자 수 입니다.
        Arrays.sort(infected);      // 정답이 여럿인 경우 더 작은 인덱스를 출력해야 하기 때문에 로직상 정렬을 해줘야 했습니다.
        for (int i = 0; i < infected.length; i++) {    
            boolean[] visited = new boolean[N];
            int cnt = 0;    // 감염자 수
            visited[infected[i]] = true;        // infected[i](감염이 시작되는 사람) 값을 인덱스로 visit 처리를 합니다.
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(infected[i]);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j = 0; j < graph[cur].length; j++) {
                    if(j == cur || visited[j] || graph[cur][j]==0) continue;    // 지금보니까 앞에 두개 조건 중에 하나는 빼도 되겠네요
                    // 밑은 감염 시킬 수 있는 경우입니다.
                    queue.add(j);
                    cnt++;
                    visited[j] = true;
                }
            }
            if(max < cnt){
                max = cnt;
                answer = infected[i];
            }
        }
        return answer;
    }
}
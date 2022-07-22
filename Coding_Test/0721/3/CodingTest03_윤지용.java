/*
1. 아이디어
infected 배열 for문 돌면서 infected 배열 한번 더 돌면서 연결이 되어 있는지 보고,
연결 되어있으면 넘어가고, 안되어 있으면 cnt 기록,
cnt가 max인거 찾으면 됨.
 */

// 8 / 20 점
// 로직이 어디가 틀렸는지 모르겠습니다..ㅜㅜ

public class test003_1 {
    public static int solution(int N, int[][] graph, int[] infected) {
        int answerIdx = 0;
        int[] cnt = new int[N]; // 감염된 사람들이 감염안된 사람들이랑 연결된 수 넣는 배열

        int linkCnt = 0;
        for (int i = 0; i < infected.length; i++) {
            int infHumanIdx = infected[i];
            boolean cureCandidate = true;
            // 감염된 사람이 또 감염된 사람이랑 연결되어 있는지만 체크
            for (int j = 0; j < infected.length; j++) {
                int checkHumanIdx = infected[j];
                if(infHumanIdx == checkHumanIdx) {
                    continue;
                }
                // 감염된 사람이랑 연결되어 있으면 (감염된 사람이랑 연결된 사람은 치료해줘도 또 좀비됨)
                if(graph[infHumanIdx][checkHumanIdx] == 1) {
                    cureCandidate = false; // 후보아님
                    break;
                }
            }
            // 치료할만한 사람이면
            if(cureCandidate) {
                for (int j = 0; j < N; j++) {
                    if(graph[infHumanIdx][j] == 1) { // 연결되어 있다면
                        linkCnt++; // 카운트
                    }
                }
                cnt[infHumanIdx] = linkCnt - 1; // 자기자신 하나 빼기(i,j가 같은 경우)
                linkCnt = 0; // 초기화
            }
        }
        int answerCnt = 0; // 안감염 사람이랑 연결된 숫자
        for (int i = 0; i < N; i++) {
            if(cnt[i] > answerCnt) { // cnt배열 돌면서 기존보다 클때만 업데이트
                answerCnt = cnt[i];
                answerIdx = i; // 출력할 인덱스 업데이트
            }
        }
        // 감염된 사람 중에 안감염된 사람이랑 연결된 사람이 아무도 없으면
        if(answerCnt == 0) {
            return infected[0]; // 인덱스 제일 낮은거 출력
        }
        return answerIdx;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] graph = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[] infected = {0, 2};
        System.out.println(solution(N, graph, infected));
    }

}

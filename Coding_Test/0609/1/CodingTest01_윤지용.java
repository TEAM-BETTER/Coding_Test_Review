public class CodingTest01_윤지용 {
    public static int solution(int N, int[][] trust) {
        int answer = 0;

        if (trust.length == 0) {
            answer = -1;
            return answer;
        }
        // 믿음 투표 완료
        int[] trustCnt = new int[N];
        for (int i = 0; i < trust.length; i++) {
            trustCnt[trust[i][1] - 1] += 1;
        }

        int tmp = 0; // 판사 후보 숫자
        int judge = 0; // 판사 후보 인덱스
        for (int i = 0; i < trustCnt.length; i++) {
            if (trustCnt[i] == N - 1) { // 만약 모두에게 믿음 당하는 사람이 있으면
                tmp += 1; // 그 사람 숫자 세기
                judge = i; // 판사 후보 인덱스 특정 (단, 정답에 들어갈땐 +1)
                if(tmp>=2) { // 판사 후보가 2명이 넘어가면
                    return -1; // 판사 없네
                }
            }
        }
        for (int i = 0; i < trust.length; i++) {
            if (trust[i][0] == (judge + 1)) { // 판사후보가 누굴 믿는다고 하면
                answer = -1; // 판사아니네
            } else {
                answer = judge + 1;
            }
        }

        /*
        if (tmp == 1) { // 한명이면
            answer = judge + 1; // 판사네
        } else { // 한명이 아니면
            answer = -1; // 판사 없네
        }
        */

        // 코테 끝나고 삼항연산자로 수정해보았음
        // answer = (tmp==1) ? judge + 1 : -1 ;
        // 그러나 이 조건이 다 위에 반복문에 들어갈 수 있어서 넣어버림.

        return answer;
    }
}

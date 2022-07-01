/*
코드는 쉽지만 제일 오래 걸렸던 문제...
테스트 끝나고 치킨 뜯었습니다.
 */
class Solution {
    public int solution(int N, int M, int[] fry, int[] clean) {
        int chicken = 0;
        int time = 0;
        while (true) {
            time += 1;
            for (int i = 0; i < N; i++) {
                if(time % (fry[i]+clean[i]) == fry[i]){     // 지금 보면 별거 아닌데 이거 한줄적는데 시간을 다 썼네요 수학 공부를 해야할 것 같아요...
                    chicken+=1;
                    if (chicken >= M) break;
                }
            }
            if (chicken >= M) break;
        }
        return time;
    }
}
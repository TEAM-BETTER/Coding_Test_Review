public class CodingTest03_윤지용 {
    class Solution {
        public int solution(int N) {
            int answer = 0;
            // 세로로 놓는건 무조건 세트로 와야하기 때문에
            // 반으로 나눠서 왼쪽열만 체크해도 됨.
            // 즉, N을 1과 2로 채우는 방법을 풀면 됨. (재귀로)

            if(N==1) { // 칸이 1개 남았을 때
                answer += 1;
                return answer;
            } else if(N==2) { // 칸이 2개 남았을 때
                answer += 2;
                return answer;
            }
            answer = solution(N-1)+solution(N-2);
            return answer;
        }
    }
}
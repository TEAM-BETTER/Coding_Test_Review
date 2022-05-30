public class CodingTest01_윤지용 {
    class Solution {
        public int solution(int n) {
            int answer = 0; // 소수개수
            int notPrimeInt = 0; // 소수인지 아닌지

            if (n == 1) {
                answer = 0;
            } else if (n == 2) {
                answer = 1;
            } else {
                for (int i = 2; i < n; i++) { // 2~n-1까지 수 중 소수 개수 구하기
                    for (int j = 2; j < i; j++) { // 2~(i-1)까지
                        if (i % j == 0) {    // 나누어떨어지는게 있으면
                            notPrimeInt++; // 소수가 아님
                            break; // 아니면 바로 탈출
                        }
                    }
                    if(notPrimeInt==0) { // 소수가 아니라는 사인이 없으면
                        answer++; // 정답 카운트 +1
                    }
                    notPrimeInt = 0; // 초기화
                }
            }
            return answer;
        }
    }
}

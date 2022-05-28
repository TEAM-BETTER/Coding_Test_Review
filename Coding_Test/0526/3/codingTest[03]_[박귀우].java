// 맥주를 쌓을수 있는 경우의 수가 전 꺼와 그 전전꺼의 합 마치 피보나치수열과 같음
class Solution_Fb {
    public int solution(int N) {
        // 피드백 받은대로 이름을 직관적으로 변경 !
        return beerStack(N);
    }

    public int beerStack(int N) {
        if (N < 2) {
            return 1;
        }
        return solution(N - 2) + solution(N - 1);
    }

    class Previous_Sol {
        public int solution(int N) {
            return likeFibo(N);
        }

        public int likeFibo(int n) {
            if (n == 1) {
                return 1; // 1인경우 1을 반환
            }
            if (n == 2) {
                return 2; // 2개인 경우 2를 반환
            }
            return likeFibo(n - 1) + likeFibo(n - 2); // 재귀호출
        }
    }
}
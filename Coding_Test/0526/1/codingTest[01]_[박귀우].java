import java.util.Arrays;

class Solution_Fb {

    public int solution(int n) {
        return countPrimeNumber(n);
    }

    static public int countPrimeNumber(int n) {
        if (n == 1)
            return 0; // n 이 1 인 경우 예외처리 !
        int[] isPrime = new int[n]; // n보다 작은 경우 이기 떄문에 딱 n 만큼 생성
        Arrays.fill(isPrime, 1);
        isPrime[0] = 0;
        isPrime[1] = 0;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) { // 에라토네스의 체를 구현 !
            if (isPrime[i] == 1) {
                for (int j = i + i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        return Arrays.stream(isPrime).sum(); // 해설강의 에서 알려준 한번에 구현하여 더해주기 .
    }

    class Previous_Sol {
        public int solution(int n) {
            int answer = 0;
            return answer;
        }

        public int countPrimeNumber(int n) {
            int[] isPrime = new int[n + 1];
            Arrays.fill(isPrime, 1);
            isPrime[0] = 0;
            isPrime[1] = 0;
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (isPrime[i] != 0) {
                    for (int j = i + i; j < i; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
            return Arrays.stream(isPrime).sum();
        }
    }
}

package codiingTest.codingTest13.p3;

// 테스트케이스 4번 오답
// m 이 n 보다 클떄와 n보다 작거나 같을때를 나누어서 풀이
// n 보다 작거나 같을 때는 nPr 을 이용한 순열 공식을 이용하면 값이 나옴
// n 보다 클 떄는 n 보다 작은 x 값이 m 의 약수이면 됨 ex) n = 4 일때 m = 8 이라면 m = 2, m = 4 두 결과를 합치면 m = 8 일 때 결과
public class Solution {
    public static final int mod = 100007;           // 오타 방지를 위한 정적변수
                                                    // 여러곳에 자주 쓰이는 복잡한 순서는 static final 로 만들어 오타 방지

    public static int solution(int n, int m) {
        int answer = 0;
        if (m > n) {                            // m 이 n 보다 클 때
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {      // m 이 가질 수 있는 최소값 2 부터 n 까지 돌면서 m 의 약수인지 확인
                answer += getCount(n, i) % mod; // getCount 메소드로 m 이 i 일 때 값을 mod 로 나눈 나머지값을 answer 에 더해줌
            }
        } else {                                // m 이 n 보다 작거나 같을 때
            answer = getCount(n, m);            // getCount 메소드로 answer 에 대입
        }
        return answer % mod;
    }

    private static int getCount(int n, int m) { // nPr 값을 구해주는 메소드
        int answer = 1;                         // n 개 중 호스트를 뺀 n - 1 개 중에 m - 1 개를 골라 순서를 배치하는 경우의 수
        n--;                                    // 그러면 (n-1)P(m - 1) 이 됨
        for (int i = 0; i < m - 1; i++) {
            answer *= n--;
            answer %= mod;
        }
        return answer % mod;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 8));
    }
}
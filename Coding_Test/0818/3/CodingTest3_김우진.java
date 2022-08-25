package CodingTest13;

/**
 * 추가 공부 필요
 *
 * 1. 호스트가 지목한 사람이 다시 호스트를 지목한 경우 르프의 길이가 제일 짧음 (길이: 2)
 *      따라서, 루프를 돈 최대횟수는 m / 2 (maxLoopCnt)
 * 2. 루프를 1번 돈 케이스부터 maxLoopCnt번 돈 케이스까지 일일이 확인
 *      m을 (루프를 돈 횟수)로 나누었을 때 나누어 떨어져야 호스트가 최종적으로 지목되어 죽음
 *      즉, 루프를 돈 횟수가 m의 약수여야 호스트가 죽음
 *      위와 같은 케이스가 아닌 경우 호스트가 죽는 케이스가 아니므로 continue
 *
 *      m을 루프를 돈 횟수로 나누면 루프의 길이가 구해짐 (loopLen)
 *      nPr을 구할 때 r <= n 조건을 성립해야하므로 loopLen <= n일 때만 계산 (n < m일 때 loopLen이 n보다 큰 케이스가 발생)
 *      순열을 구해줘야하는데 호스트는 뺀 상태로 순열을 구해줘야하므로 n - 1 P loopLen - 1을 answer에 더해줌
 */
public class CodingTest3_김우진 {


    static final int MOD = 100007;

    static long getPermutation(int n, int k) {
        long result = 1;

        for (long i = n - k + 1; i <= n; i++) {
            result *= i;

            result %= MOD;
        }

        return result;
    }

    public static int solution(int n, int m) {
        int maxLoopCnt = m / 2;
        int answer = 0;

        for (int loopCnt = 1; loopCnt <= maxLoopCnt; loopCnt++) {
            if (m % loopCnt != 0) {
                continue;
            }

            int loopLen = m / loopCnt;

            if (loopLen <= n) {
                answer += (int) (getPermutation(n - 1, loopLen - 1) % MOD);
            }
        }

        return answer % MOD;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 3;

        System.out.println(solution(n, m));
    }
}

class Solution {
    static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 0;

        if (M == 3) {
            for (int i = 0; i <= capacity[0]; i++) {
                for (int j = 0; j <= capacity[1]; j++) {
                    for (int k = 0; k <= capacity[2]; k++) {
                        if (i + j + k == N)
                            answer += P(N, i) * P(N-i, j) * P(N-i-j, k) * P(K, M) / factorial[i] / factorial[j] / factorial[k];
                    }
                }
            }
        }
        else if (M == 2) {
            for (int i = 0; i <= capacity[0]; i++) {
                for (int j = 0; j <= capacity[1]; j++) {
                    if (i + j == N)
                        answer += P(N, i) * P(N-i, j) * P(K, M) / factorial[i] / factorial[j];
                }
            }
        } else if (M == 1) {
            if (capacity[0] > N)
                answer += 1 * P(K, M);
        }

        return answer;

    }

    public int P(int n, int count) {
        if (n == 0 || count == 0)
            return 1;
        int sum = 1;
        while(count > 0) {
            sum *= n;
            n--;
            count--;
        }
        return sum;
    }
}
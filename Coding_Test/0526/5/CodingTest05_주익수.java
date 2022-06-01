class Solution {
    static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800}; //facotorial 사용, 0!의 경우 0을 반환하는데, 나눗셈에 이용되므로 1로 조정
    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 0;

        if (M == 3) { //시험실이 3개인 경우
            for (int i = 0; i <= capacity[0]; i++) { //각 시험실의 학생 숫자를 늘려가며 학생 정원에 도달할때, 경우의 수 계산
                for (int j = 0; j <= capacity[1]; j++) {
                    for (int k = 0; k <= capacity[2]; k++) {
                        if (i + j + k == N) //시험실에 학생을 채우지 않는 경우의수를 고려하여 다음과 같은 식 구성, 식의 경우, 문제에 나타난 풀이법 참고하였음
                            answer += P(N, i) * P(N-i, j) * P(N-i-j, k) * P(K, M) / factorial[i] / factorial[j] / factorial[k];
                    }
                }
            }
        }
        else if (M == 2) { //시험실이 2개인 경우
            for (int i = 0; i <= capacity[0]; i++) {
                for (int j = 0; j <= capacity[1]; j++) {
                    if (i + j == N) //시험실에 학생이 없는 경우의 수를 고려하여 다음과 같은 식 구성
                        answer += P(N, i) * P(N-i, j) * P(K, M) / factorial[i] / factorial[j];
                }
            }
        } else if (M == 1) { //시험실이 하나밖에 없는 경우,
            if (capacity[0] > N)
                answer += 1 * P(K, M);
        }

        return answer;

    }

    public int P(int n, int count) { //순열을 구현해주는 함수
        if (n == 0) //비어있는 교실을 고려하여 n이 0일 경우 1을 반환하도록 하였음
            return 1;
        int sum = 1;
        while(count > 0) { //count가 0일수도 있으나 위에서 sum을 초기화해주어 반환값이 제대로 넘어가기 때문에 if문으로 따로 정의하지 않았음
            sum *= n;
            n--;
            count--;
        }
        return sum;
    }
}
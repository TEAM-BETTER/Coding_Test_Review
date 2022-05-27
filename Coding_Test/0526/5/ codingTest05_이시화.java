// ********************************주의***************************
// 이 문제는 너무 어려워서 설명을 개판으로 해놨습니다. 읽으셔도 알아보기 힘드실꺼에요....

// 학생수가 딱 맞을 때는 코드를 완성시켰지만
// 자리수가 학생수보다 많을 때는 코드를 코테 이후에 완성시켰습니다.

// 1. 학생수와 자리수가 딱 맞을때
// 1. N == totalCapacity 일 때 그냥 그림에 그려진 공식을 코드로 구현하였습니다.

// 2. 자리가 남을 때 코드를 따로 구했습니다.
// 2. 교실수 M 이 2 인 경우와  3 인 경우를 나누어서 코드를 구현하였습니다.
//
// 먼저 학생수 N 이 3 이교 교실 수가 M capacity = {2, 2} 인 경우를 예로 들어 설명하겠습니다.
// 학생수가 자리수보다 적은 경우의 수를 그림의 공식으로 측정하려면 너무 많은 경우의 수가 존재하여 저 방식으로는 하지 않았습니다.

//  __학생__학생__학생__ 먼저 모든 학생을 배열한 다음 학생들 사이(__)에 벽(||)을 쳐서 교실을 나누는 방법을 택하였습니다.
// 벽 하나를 만들면 학생은 두 집단으로 나누어져 교실에 들어갈 수 있게 됩니다. 이때 나누어진 두 집단이 각 교실의 크기보다 큰지 확인합니다.
// 만약 벽이 __학생||학생__학생 과 같이 생성된다면 학생은 1, 2 명씩 나누어 집니다.
// 이때 학생이 나누어 지는 경우의 수를 곱해주면 capacity[0]에 1명 capacity[1]에 2명이 들어가는 경우의 수를 구할 수 있게 됩니다.
// 위와 같은 방식으로 모든 경우의 수를 구하면서 더해주는 코드를 구현하였습니다.


// 구현한 코드를 글로 설명하는건 정말 힘드네요... 그림이라도 그릴 수 있으면 좋을텐데

public class Solution {
    public static long solution(int N, int M, int K, int[] capacity) {
        long answer;
        if (M == 1) {                   // 교실이 하나일 때 모두 하나의 교실에 들어가는 경우의 수는 1이므로 1을 반환합니다.
            return 1;
        }

        int totalCapacity = 0;          // 교실에 들어갈 수 있는 총 자리 수를 구합니다.
        for (int CC : capacity) {
            totalCapacity += CC;
        }

        if (totalCapacity > N) {        // 총 자리수가 학생 수보다 클때 코드입니다.
            answer = 0;
            if (M == 2) {               // 교실이 두개일 때 코드 입니다.
                for (int i = 0; i <= N; i++) {                  //  __학생__학생__학생__ 먼저 모든 학생을 배열한 다음 학생들 사이(__)에 벽을 쳐서 교실을 나누는 방법을 택하였습니다.
                    int temp = 1;
                    if (i > capacity[0] || N - i > capacity[1]) continue;// 벽 하나를 만들면 학생은 두 집단으로 나누어져 교실에 들어갈 수 있게 됩니다. 이때 나누어진 두 집단이 각 교실의 크기보다 큰지 확인합니다.
                    for (int j = N; j > N - i; j--) {                   // 가능하다면 나누어진 학생들의 경우의 수를 구합니다.
                        temp *= j;                                      // 43 ~ 52 번 줄은 nCr 공식을 구현한 코드입니다.
                    }

                    for (int j = 1; j <= i; j++) {
                        temp /= j;
                    }

                    answer += temp;                                     // 벽을 나누어진 경우의 수를 하나씩 더하면서 구합니다.
                }

            } else {
                for (int i = 0; i <= N; i++) {                          // 교실 M 이 3일 경우 위의 경우를 한번 더 반복해 주면 됩니다,
                    int temp = 1;
                    if (i > capacity[0] || N - i > capacity[1] + capacity[2]) continue; // 첫번째 벽이 교실 용량에 알맞게 나누어 졌는지 확인

                    for (int j = N; j > N - i; j--) {
                        temp *= j;
                    }

                    for (int j = 1; j <= i; j++) {
                        temp /= j;
                    }

                    for (int j = i; j <= N; j++) {
                        int temp2 = 1;
                        if (j - i > capacity[1] || N - j > capacity[2]) continue;       // 두번째 벽이 교실 용량에 알맞게 나누어 졌는지 확인
                        for (int k = N - i; k > N - j; k--) {
                            temp2 *= k;
                        }

                        for (int k = 1; k <= j - i; k++) {
                            temp2 /= k;
                        }
                        temp *= temp2;
                        answer += temp;
                        temp /= temp2;
                    }

                }
            }


        } else {
            answer = 1;
            for (int j : capacity) {
                answer *= nCr(N, j);
                N -= j;
            }
        }


        long gam = 1;
        if (K != M) {
            for (int i = K - M; i <= K; i++) {
                gam *= i;
            }
        }
        answer *= gam;

        return answer;
    }

    public static long nCr(int n, int c) {
        int result = 1;

        if (n == 0 || n == 1 || c == 0) {
            return 1;
        }

        for (int i = n - c + 1; i <= n; i++) {
            result *= i;
        }

        for (int i = 1; i <= c; i++) {
            result /= i;
        }

        return result;
    }
}

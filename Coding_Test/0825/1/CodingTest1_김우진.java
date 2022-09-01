package CodingTest14;

/**
 * 1. 최대공약수 문제
 *      대각선 방향으로 잘랐을 때 지나는 점을 기준으로 정사각형이 대각선으로 바르게 나뉜다.
 *      N, M의 최대공약수 = 직선이 지나는 사각형의 갯수
 *
 *     두 수의 최대공약수가 1인 경우 : N + M - 1
 *     두 수의 최대공약수가 1보다 큰 경우 : N + M - 최대공약수
 *
 */
public class CodingTest1_김우진 {
    static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return GCD(b, a % b);
    }

    public static int solution(int N, int M) {
        int a = Math.max(N, M);
        int b = Math.min(N, M);

        return a + b - GCD(a, b);
    }

    public static void main(String[] args) {
        int N = 4;
        int M = 9;

        System.out.println(solution(N, M));
    }
}
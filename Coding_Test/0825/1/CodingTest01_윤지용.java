/*
아이디어
앞의 버림과 뒤의 올림의 차만큼 색칠됨.
예제에서 보면 가로 4, 세로 9인데,
첫번째 구간은 0 ~ 9/4 * 1 = 0 ~ 2.XX --(버림,올림작업)--> 0 ~ 3 => 3개
두번째 구간은 9/4 * 1 ~ 9/4 * 2 = 2.XX ~ 4.XX --(버림,올림작업)--> 2 ~ 5 => 3개
이런식으로 구했습니다.

점수는 16 / 20점으로 하나 틀렸네요.. 엣지케이스를 잘 모르겠습니다.
 */


public class CodingTest01 {
    public static int solution(int N, int M) {
        if(N == M) {
            return N;
        }

        int answer = 0;

        int big = Math.max(N, M);
        int small = Math.min(N, M);

        double per = (double)big / (double)small;

        for (int i = 1; i <= small; i++) {
            int front = (int)Math.floor(per * (i - 1));
            int back = (int)Math.ceil(per * i);
            answer += back - front;
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 10;
        int M = 3;
        System.out.println(solution(N, M));
    }
}

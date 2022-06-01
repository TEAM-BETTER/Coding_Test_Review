// 이 문제는 N이 1 ~ 6 정도까지 손으로 그려보다가 일정한 규칙이 있어서 간단하게 풀었습니다.
// N = 1    answer = 1
// N = 2    answer = 2
// N = 3    answer = 3
// N = 4    answer = 5
// N = 5    answer = 8
// N = 6    answer = 13
// 다음과 같은 규칙이 있어 답을 찾을수 있었습니다.
//  00 은 맥주잔을 가로로 두개(二) 둔거라 생각하시면 됩니다.

//
//  1   1                                                       N = 1  answer = 1
//  2   11  00                                                  N = 2  answer = 2
//  3   (11+1  00+1) [N = 2 인 맥주잔에 1 한개를 왼쪽에 붙인것]            (1+00) [N = 1 인 맥주잔에 00을 왼쪽에 붙인것]
//  4   (111+1 001+1 100+1) [N = 3 인 맥주잔에 1 한개를 왼쪽에 붙인것 ]   (11+00 00 +00) [N = 2 인 맥주잔에 00을 왼쪽에 붙인것]
//  5   (1111+1 0011+1 1001+1)      (111+00 001+00)

public class Solution {
    public int solution(int N) {
        int answer = 0;

        if (N == 1) {
            return 1;
        }

        if (N == 2) {
            return 2;
        }

        answer = solution(N - 1) + solution(N - 2);

        return answer;
    }
}

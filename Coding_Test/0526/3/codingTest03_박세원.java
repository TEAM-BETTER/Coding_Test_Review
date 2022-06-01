/*
 문제해결전략

 1. 직사각형을 쌓으면서 방법의 수가 어떻게 나오는지 규칙을 찾아야함.
 2. N값이 1일때 방법의 수를 S(1)이라고 했을때,
  S(1) = 1 (뉘여져있는거 하나)
  S(2) = 2 (뉘여서 두개 쌓은거 두개 세워둔거 2가지임)
  S(3) = 뉘여져 있는경우 높이 1을 차지하므로 위에 N(2)개의 방법만큼 쌓을 수 있음 + 세워져있는 경우 높이 2를 차지하므로 N(1)개만큼 쌓을 수 있음
  ......
  S(N) = 뉘여서 놓는경우 S(N-1) + 세워서 놓는 경우 S(N-2)

  S(1) = 1 / S(2) = 2인 피보나치수열임

 3. 피보나치수열 구현 (재귀가 반응속도가 느리다고 들어서 for문으로 구성해봄)
*/

public class Solution3 {
    public int solution(int N) {
        int answer = 0;
        int a1 = 1;
        int a2 = 2;

        if(N == 1){
            answer = a1;
        } else if(N == 2) {
            answer = a2;
        }
        for (int i = 3; i <= N; i++) {
            answer = a1 + a2;
            a1 = a2;
            a2 = answer;

        }
        return answer;
    }
}
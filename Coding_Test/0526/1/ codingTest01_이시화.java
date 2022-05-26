// 소수를 구하는 방법인 에라토스테네스의 체 입니다!!
// https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4
// 링크 첨부합니다 이거 보시면 이 문제 아주 쉽게 풀 수 있습니다.!!
//
public class Solution {
    public static int solution(int n) {
        int answer = 0;
        boolean[] sosu = new boolean[n + 1];            // 소수인지 아닌지 판별할 배열 true = 소수 X false = 소수
        sosu[0] = true;                                 // 0과 1은 소수가 아니여서 처음에 true 값을 넣어줍니다.
        sosu[1] = true;                                 //

        for (int i = 2; i * i < n; i++) {               // 에라토스테네스의 체입니다!!
            if (!sosu[i]) {                             //
                for (int j = i * i; j < n; j += i) {
                    sosu[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {                   // 에라토스테네스의 체로 소수와 아닌것을 구분후 false 인배열의 갯수를 측정합니다!
            if (!sosu[i]) {
                answer++;
            }
        }

        return answer;
    }
}

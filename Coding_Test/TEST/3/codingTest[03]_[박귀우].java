
/** 프로그래머스 3번 문제 */
// 각 자리 숫자의 합을 구하라.
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n != 0) { // n 이 0 이 될때까지 나머지를 더해주고 n은 10 으로 나눠줍니다.
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
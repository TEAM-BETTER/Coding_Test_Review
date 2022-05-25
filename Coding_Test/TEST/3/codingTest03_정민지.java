import java.util.*;
/* 자릿수를 다 더하는 문제, 123이면 1 + 2 + 3 => 6 */
public class Solution {
    public int solution(int n) {
        int answer = 0;
        /* 넘어온 숫자 n을 String으로 변환하고 그 문자열의 길이만큼 반복 */
        for (int i = 0; i < Integer.toString(n).length(); i++) {
          /*
            String으로 변환한 n의 i번째 char(문자)를 가져와 -'0'하여
            정수로 변환하고 answer에 더함
           */
            answer += Integer.toString(n).charAt(i) - '0';
        }
        return answer;
    }
}

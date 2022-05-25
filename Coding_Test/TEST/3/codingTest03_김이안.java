import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        char[] arr = ("" + n).toCharArray();    // String.toCharArray 를 이용해 int to char[] 변환
        for (char c : arr) {
            answer += c-'0';                    // 숫자가 아스키코드 값으로 되어있기 때문에 -'0'
        }
        return answer;
    }
}
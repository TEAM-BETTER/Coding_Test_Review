import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        // 숫자의 % 10을 하면 1의 자리수를 구할수 있고 그 수를 더한다
        // 다음 자리수를 얻기위해 10을 나눠준다.
        while(n != 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
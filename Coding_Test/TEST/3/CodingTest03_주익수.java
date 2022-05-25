/**
 * 금일 프로그래머스 3번 문제
 */

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1;

        while (num < 1000000000) {
            answer += n / num % 10;
            num *= 10;
        }

        return answer;
    }
}

/**
 * 아메바 ptsd 왔습니다... 못풀었네요.
 */

import java.util.*;

class Solution {
    public int solution(int n, int m) {
        int answer = 1;
        for (int i = 1; i < m - 2; i++) {
            answer *= i;
        }
        return answer;
    }
}
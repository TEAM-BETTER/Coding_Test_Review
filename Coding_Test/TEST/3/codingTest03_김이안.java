import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        char[] arr = ("" + n).toCharArray();
        for (char c : arr) {
            answer += c-'0';
        }
        return answer;
    }
}
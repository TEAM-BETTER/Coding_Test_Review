import java.util.*;
class Solution {
    public boolean solution(String s, String t) {
        // 길이가 다를 경우 X
        if (s.length() != t.length()) return false;
        // 문자 배열로 변환
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        char[] tChar = t.toCharArray();
        Arrays.sort(tChar);
        int count = 0;
        // 값을 빼고 더하는데 서로 같은 문자를 가지고 있다면
        // 최종적으로 0이 되어야 함
        for (int i = 0; i < sChar.length; i++) {
            count += (sChar[i] - 'a') - (tChar[i] - 'a');
        }
        return count == 0;
    }
}

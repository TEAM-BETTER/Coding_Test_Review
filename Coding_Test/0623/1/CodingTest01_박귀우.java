// s 에 알파벳 소문자만 주어지기 때문에 소문자만 체크하면 된다고 생각해 알파벳 배열을 생성하고
// 그 배열에 ++-- 를 기록해 0을카운트 해주는 방식을 채용했습니다.
// 문제를 잘못이해해서 소문자가 전부 다음 문자에 들어가면 그게 에너그램인줄 알고 이렇게 구현했습니다.

import java.util.*;

class CodingTest01_박귀우 {
    public boolean solution(String s, String t) {
        if (s.length() > t.length())
            return false; // 만약 s의문자가 더많다면 false 이기에 이렇게 선정했습니다.
        int[] alphabets = new int[26]; // 알파벳 배열
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabets[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] != 0)
                return false; // 1개라도 1이 아니라면 false 를 리턴합니다.
        }
        return true;
    }
}
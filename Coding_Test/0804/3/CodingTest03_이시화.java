package codiingTest.codingTest11.p3;

import java.util.Arrays;
import java.util.Objects;

// String 메서드를 이용하여 푸는 문제
public class Solution {
    public static boolean solution(String s, String[] words) {
        boolean answer = false;
        // 예외처리
        // s 가 빈 문자열일 때 words 에 빈 문자열이 없으면 false 반환
        if (Objects.equals(s, "") && !Arrays.asList(words).contains("")) {
            return false;
        }

        // words 의 단어로 시작된다면 find 메서드 시작
        for (String word : words) {
            if (s.startsWith(word)) {                               // find 함수 재귀로 탐색
                answer = find(s.substring(word.length()), words);    // words 에 단어로 시작된다면 s 에서 words 단어를 제거하고 재귀함수에 넣어줌
            }
            if (answer) {
                return true;
            }
        }

        return false;
    }

    public static boolean find(String s, String[] words) {   // 재귀 함수
        if (s.length() == 0) {                              // 남아있는 s 문자열이 없다면 true 반환
            return true;
        }

        for (String word : words) {                         // 다시 words 에 단어로 시작하는지 탐색
            if (s.startsWith(word)) {
                String substring = s.substring(word.length());  // 시작한다면 sub String 만들어서 다시 find 함수 실행
                return find(substring, words);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"zer", "ro", "ze", "base"};
        System.out.println(solution("zerobase", ss));
    }

}

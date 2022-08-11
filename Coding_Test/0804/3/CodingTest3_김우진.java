package CodingTest11;

import java.util.ArrayList;

/**
 * 정확성: 8 / 효율성: 6
 * 1. 이중 ArrayList 를 이용하여 wordList에 알파벳순으로 words 의 String들을 모아둡니다.
 *
 * 2. func 메서드를 통해 주어진 문자열의 맨 앞의 char와 wordList의 알파벳이 맞는지 확인합니다.
 *      -> 동일하다면 주어진 문자열 s에서 wordList의 단어의 길이가 맞는지 확인,
 *      -> 맞다면 단어 길이를 idx값으로 넘기고 다시 func 메서드의 재귀 반복해서
 *      문자열 s와 단어들의 조합으로 문자열 구성이 가능한지 찾습니다.
 *
 * 3. idx값과 s의 길이가 같으면 조합 가능으로 true 리턴, 길이를 넘으면 false 리턴
 *
 */
public class CodingTest3_김우진 {

    static ArrayList<ArrayList<String>> wordList = new ArrayList<>();

    static boolean answer = false;

    static void func(int idx, String s) {
        if (idx > s.length()) {
            return;
        }

        /**
         * idx가 s.length()라는 것은 words 조합으로 s를 만들었다는 뜻으로 answer = true
         */
        if (idx == s.length()) {
            answer = true;

            return;
        }

        char c = s.charAt(idx);
        int listIdx = c >= 'a' && c <= 'z' ? s.charAt(idx) - 'a' : s.charAt(idx) - 'A';

        /**
         * 현재 idx번째 알파벳을 토대로 어떤 index를 참조할지 찾고
         * 해당 알파벳으로 시작하는 단어와 동일한 구간이 있을 경우 재귀를 이어나가고
         * 없을 경우 재귀를 이어나가지 않음
         */
        for (String word : wordList.get(listIdx)) {
            int len = word.length();

            if (idx + len > s.length()) {
                continue;
            }

            if (s.substring(idx, idx + len).equals(word)) {
                func(idx + len, s);
            }
        }
    }

    public static boolean solution(String s, String[] words) {
        for (int i = 0; i < 26; i++) {
            wordList.add(new ArrayList<>());
        }

        for (String word : words) {
            char c = word.charAt(0);
            int idx = c >= 'a' && c <= 'z' ? c - 'a' : c - 'A';

            wordList.get(idx).add(word);
        }

        func(0, s);

        return answer;
    }

    public static void main(String[] args) {
        String s = "zerobase";
        String[] words = {"zer", "ro", "ze", "base"};

        System.out.println(solution(s, words));
    }
}
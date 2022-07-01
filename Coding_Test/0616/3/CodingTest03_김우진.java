package CodingTest4;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 이 문제에서는 *가 아닌 ?로 query의 length가 고정되어있음,
 * word와 query의 길이가 일치해야함, 또 ?는 query 단어의 뒤에 붙어있음
 * 2. 물음표 전까지 query의 부분문자열을 변수에 저장 //
 * 3. query의 단어길이와 word의 단어길이 가 맞는지 체크
 * 4. 맞으면 2번에서 구한 물음표 전까지 query의 부분문자열과 word의 부분문자열이 일치하는지 체크
 * 5. 두 부분 다 일치하면 match 배열에 word추가
 * 6. 모든 반복문 돌면서 일치하는 단어 찾으면 answer[i] 배열에 넣어줌
 *  answer[i] 배열의 길이는 match배열의 길이만큼 사이즈 조절
 */

class CodingTest03_김우진 {
    public static String[][] solution(String[] words, String[] queries) {
        String[][] answer = new String[queries.length][words.length];

        for (int i = 0; i < queries.length; i++) {
            int queryLength = queries[i].length();

            String queryBeforeQuestion = "";

            for (int j = 0; j < queries[i].length(); j++) {
                if (queries[i].charAt(j) == '?') {
                    queryBeforeQuestion = queries[i].substring(0, j);
                    break;
                }
            }

            List<String> matches = new ArrayList<>();

            for (String word : words) {
                if (word.length() != queryLength) {
                    continue;
                }

                if (word.substring(0, queryBeforeQuestion.length()).equals(queryBeforeQuestion)) {
                    matches.add(word);
                }
            }

            answer[i] = new String[matches.size()];

            for (int j = 0; j < matches.size(); j++) {
                answer[i][j] = matches.get(j);
            }
        }
        return answer;
    }
}
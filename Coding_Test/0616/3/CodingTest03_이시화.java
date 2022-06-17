import java.util.ArrayList;
import java.util.Arrays;

// Trie 로 풀어야 하는 문제지만
// 앞의 1, 2 번과 비슷해서 String 메소드로 풀이
public class Solution {
    public static String[][] solution(String[] words, String[] queries) {
        String[][] answer = new String[queries.length][];                   // 정답 return 을 위한 배열

        for (int i = 0; i < queries.length; i++) {                          // queries 돌면서 words 에서 탐색
            ArrayList<String> line = new ArrayList<>();                     // 담아야할 배열의 갯수를 몰라서 임의로 List 생성하여 받음
            int size = queries[i].length();                                 // queries 배열 길이
                                                                            // -> 배열 길이를 저장해서 이 길이에 맞는 단어 찾기 위함(?? 갯수 때문 )
            boolean first = queries[i].startsWith("?");                      // ?로 시작하는지 알아보는 boolean ?로 시작하면 true 아니면 false
            String q = queries[i].replaceAll("[?]", "");   // queries 인자의 ? 제거해서 q 에 저장

            for (String word : words) {
                if (!first && word.length() == size && word.startsWith(q)) {  // ?가 뒤에 있고 단어 길이가 물음표를 포함한 길이고 q 로 시작하는 단어 찾기
                    line.add(word);
                }

                if (first && word.length() == size && word.endsWith(q)) {    // ?가 앞에 있고 단어 길이가 물음표를 포함한 길이고 q 로 끝나는 단어 찾기
                    line.add(word);
                }
            }
            answer[i] = line.toArray(new String[line.size()]);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"hello", "hear", "hell", "good", "goose", "children", "card", "teachable"};
        String[] b = {"he??", "g???", "childre?", "goo????", "?"};
        System.out.println(Arrays.deepToString(solution(a, b)));
    }
}

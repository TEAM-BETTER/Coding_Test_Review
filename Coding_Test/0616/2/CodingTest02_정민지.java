import java.util.*;
class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String word = "";
            boolean isStart = false;
            /*
              문자열을 *를 제외한 단어로 잘라내는 과정
              *로 시작할 경우 해당 단어로 끝이 나는 경우임. 해당 문자열에서 *는 잘라냄
             */
            if (queries[i].charAt(0) == '*') {
                word = queries[i].substring(1);
            } else if (queries[i].charAt(queries[i].length() - 1) == '*') {
              /* *로 끝이날 경우 해당 단어로 시작하는 경우임. 해당 문자열에서 *는 잘라냄 */
                word = queries[i].substring(0, queries[i].length() - 1);
                isStart = true;
            }
            for (int j = 0; j < words.length; j++) {
              // words[j]가 queries[i]로 시작하거나 끝날 경우 해당 자리에 +1 해줌
                if (isStart) answer[i] += words[j].startsWith(word) ? 1 : 0;
                else answer[i] += words[j].endsWith(word) ? 1 : 0;
            }
        }
        return answer;
    }
}

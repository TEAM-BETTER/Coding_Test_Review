import java.util.*;
class Solution {
    public String[][] solution(String[] words, String[] queries) {
        String[][] answer = new String[queries.length][0];

        for (int i = 0; i < queries.length; i++) {
            int idx = 0;
            for (int j = 0; j < words.length; j++) {
              // 만약 단어의 길이가 같지 않으면 그 단어로 시작을 해도 매칭되는 것이 아니니 패스
                if (queries[i].length() != words[j].length()) continue;
                // 물음표는 반드시 하나가 있다고 했음. queries[i]의 길이가 1이라면
                // 물음표 하나이기 때문에 빈 문자열, 그게 아니라면 물음표를 제외한 글자로
                // 데이터를 잘라내서 가져옴
                String word = queries[i].length() == 1 ? ""
                            : queries[i].substring(0, queries[i].indexOf("?"));
                // 만약 words[j]가 queries로 시작한다
                if (words[j].startsWith(word)) {
                  // length가 0, 즉 초기화 상태라면 우선 배열 공간 하나를 할당
                    if (answer[i].length == 0) answer[i] = new String[1];
                    // 이미 해당 자리에 데이터가 들어와있다면 공간 하나를 더 늘려줌
                    if (answer[i][idx] != null) {
                        answer[i] = Arrays.copyOf(answer[i], idx + 2);
                        idx++;
                    }
                    // 해당 자리에 데이터 할당
                    answer[i][idx] = words[j];
                }
            }
        }
        return answer;
    }
}

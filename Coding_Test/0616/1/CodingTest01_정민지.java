import java.util.*;
/*
  트라이를 사용해서 풀어보려고 했으나
  그렇게 했을 때 빠른 시간 안에 풀 자신이 없어서
  중첩 for문과 함수를 이용했습니다. ㅠㅠ
 */
class Solution {
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = new String[problems.length][0];

        for (int i = 0; i < problems.length; i++) {
            int idx = 0;
            for (int j = 0; j < lyrics.length; j++) {
              // 만약 lyrics[j]가 problems[i]로 시작한다
                if (lyrics[j].startsWith(problems[i])) {
                  // 시작을 하는데 length가 0이라면 (초기화 상태라면 새롭게 공간 하나 할당)
                    if (answer[i].length == 0) answer[i] = new String[1];
                    // 해당 공간에 이미 데이터가 들어와있다면
                    if (answer[i][idx] != null) {
                      // 새롭게 배열 공간을 하나 늘려줌
                        answer[i] = Arrays.copyOf(answer[i], idx + 2);
                        idx++;
                    }
                    // 데이터 삽입
                    answer[i][idx] = titles[j];
                }
            }
        }
        return answer;
    }
}

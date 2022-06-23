import java.util.ArrayList;
import java.util.Arrays;

//효율성 테스트 8점 정확성 10점짜리 코드 입니다.
class Solution {
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        int m = problems.length;
        String[][] answer = new String[m][];

        for (int i = 0; i < problems.length; i++) {
            ArrayList<String> answers = new ArrayList<>();

            for(int j = 0; j < lyrics.length; j++) {
                String problem = problems[i];
                String subLyrics = lyrics[j].substring(0, problem.length()); //lyrics에서 problem만큼 읽어오기

                if (problem.equals(subLyrics)) { //비교해서 맞으면 정답에 추가
                    answers.add(titles[j]);
                }
            }


            if (answers.size() == 0) { // 일치하는 답이 없으면 빈 배열
                answer[i] = new String[0];
            }else {
                answer[i] = new String[answers.size()];
                for(int j = 0; j < answer[i].length; j++) {
                    answer[i][j] = answers.get(j);
                }
            }
        }
        return answer;
    }
}
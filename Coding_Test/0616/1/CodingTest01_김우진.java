package CodingTest4;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. titles: 노래제목, lyrics: 가사, problems: 시작가사
 * 가사의 시작이 problems와 매치하는 제목을 2차원 배열에 넣고 리턴
 * 2. 시작가사만큼 반복하면서 startsWith 함수로 가사가 맞는것을 찾아 노래제목을 list에 넣어줌
 * 3. answer[i] 배열의 길이는 list만큼으로 사이즈 재조정
 * 4. list에 들어간 노래제목을 answer[i][j]에 넣어줌
 */

class CodingTest01_김우진 {
    public static String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        int N = titles.length;
        int M = problems.length;
        String[][] answer = new String[M][N];

        for (int i = 0; i < M; i++) {
            List<String> list = new ArrayList<>();

            for (int j = 0; j < lyrics.length; j++) {
                if (lyrics[j].startsWith(problems[i])) {
                    list.add(titles[j]);
                }
            }

            answer[i] = new String[list.size()];

            for (int j = 0; j < list.size(); j++) {
                answer[i][j] = list.get(j);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] titles = {"아모르파티", "아기상어", "올챙이와개구리", "산다는건"};
        String[] lyrics = {"산다는게다그런거지누구나빈손으로와...(후략)",
                "아기상어뚜루루뚜루귀여운뚜루루뚜루...(후략)",
                "개울가에올챙이한마리꼬물꼬물헤엄치다...(후략)",
                "산다는건다그런거래요힘들고아픈날도많지만...(후략)"};
        String[] problems = {"산다", "아기상어", "올챙이"};

        String[][] answer = solution(titles, lyrics, problems);

        for (String[] a : answer) {
            for (String b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
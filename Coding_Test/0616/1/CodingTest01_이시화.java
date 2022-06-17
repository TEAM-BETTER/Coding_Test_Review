import java.util.ArrayList;
import java.util.Arrays;

// 강의에서 배운 trie 를 사용 해야 할 것 같았는데 String 의 starsWith 라는 메소드를 활용 하는게 더 간단하게 풀 수 있을 것 같아서 starsWith 사용
// 시간복잡도
// Trie : 생성 복잡도 + 탐색 복잡도 = O(MN) + O(MN)
// statsWith : 탐색 복잡도 = O(N^4)????
public class Solution {
    public static String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = new String[problems.length][];          // 정답을 출력할 String[][] 배열
        ArrayList<String> line;                                     // 정답을 받을 배열(정답의 갯수를 알 수 없어서 Array 보단 List로 구현)

        for (int i = 0; i < problems.length; i++) {                 // problems 배열을 돌면서 각 가사에 비교하는 for 문
            line = new ArrayList<>();                               // 정답 담을 배열 초기화
            for (int j = 0; j < lyrics.length; j++) {               // lyrics 배열에 하나하나 비교하며 추가
                if (lyrics[j].startsWith(problems[i])) {            // String 메소드인 startsWith 를 사용하여 problems 배열의 인자 하나를 각 노래 가사와 비교
                    line.add(titles[j]);                            // 일치한다면 정답 배열에 추가
                }
            }
            String[] ArrayLine = line.toArray(new String[line.size()]); // 정답을 담은 임의 배열인 line 을 answer 에 추가
            answer[i] = ArrayLine;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"아모르파티", "아기상어", "올챙이와개구리", "산다는건"};
        String[] b = {"산다는게다그런거지누구나빈손으로와...(후략)", "아기상어뚜루루뚜루귀여운뚜루루뚜루...(후략)", "개울가에올챙이한마리꼬물꼬물헤엄치다...(후략)", "산다는건다그런거래요힘들고아픈날도많지만...(후략)"};
        String[] c = {"산다", "아기상어", "올챙이"};
        System.out.println(Arrays.toString(Arrays.stream(solution(a, b, c)).toArray()));
    }

}

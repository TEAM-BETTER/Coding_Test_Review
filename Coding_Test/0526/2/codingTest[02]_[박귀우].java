import java.util.*;

class Solution2_Fb {
    public int solution(String[] names) {
        return getWinnerCases(names);
    }

    public int getWinnerCases(String[] names) { // 좀더 명확한 함수 명을 지정
        // 중복 된 이름을 제거하는 과정(윤시화님 코드에서 따왔어요)
        HashSet<String> set = new HashSet<>(Arrays.asList(names));
        int top = 1;
        int bottom = 24;
        for (int i = 0; i < 4; i++) {
            top *= set.size() - i;
        }
        return (int) (top / bottom);
    }

    class Previous_Sol {
        public int solution(String[] names) {
            return getNums(names);
        }

        public int getNums(String[] s) {
            HashSet<String> set = new HashSet<String>(); // 헤쉬셋을 이용해 중복을 제거
            set.addAll(List.of(s)); // 현재 주어진 리스트를 셋에 입력.
            long topFactorial = 1;
            int botFactorial = 24; // 4 가지를 뽑을 수 는 정해져 있음.
            for (int i = set.size(); i > set.size() - 4; i--) {
                topFactorial = (topFactorial * i);
            }
            return (int) (topFactorial / botFactorial);
        }
    }
}